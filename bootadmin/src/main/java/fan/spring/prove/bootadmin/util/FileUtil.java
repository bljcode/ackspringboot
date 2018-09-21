package fan.spring.prove.bootadmin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by fanlingjie on 2018/9/10.
 */
public class FileUtil {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    //默认下载超时时间
    private static final int downloadTimeout = 10000;

    public static boolean createFile(String filePath){
        File file = new File(filePath);
        if(file.exists()) {
            logger.error("创建文件" + filePath + "失败，目标文件已存在！");
            return false;
        }
        if (filePath.endsWith(File.separator)) {
            logger.error("创建单个文件" + filePath + "失败，目标文件不能为目录！");
            return false;
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                logger.info("创建单个文件" + filePath + "成功！");
                return true;
            } else {
                logger.error("创建单个文件" + filePath + "失败！");
                return false;
            }
        } catch (IOException e) {
            logger.error("创建单个文件" + filePath + "失败！" + e.getMessage());
            return false;
        }
    }
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            logger.warn("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            logger.info("创建目录" + destDirName + "成功！");
            return true;
        } else {
            logger.info("创建目录" + destDirName + "失败！");
            return false;
        }
    }


    public static String getDataPath() throws FileNotFoundException {

        return ResourceUtils.getURL("classpath:").getPath();

    }
    public static boolean exitFile(String filePath){
        File desFile = new File(filePath);
        if(desFile.exists() && desFile.isFile()){
            return true;
        }
        return false;
    }
    public static boolean getFileByHttp(String url, String filePath){
        return getFileByHttp(url,filePath,downloadTimeout);
    }

    public static boolean renameFile(String oldFilePath,String newFilePath){
        File old = new File(oldFilePath);
        File dest = new File(newFilePath);
        if(!old.exists()){
            return false;
        }
        if(dest.exists() && dest.isFile())
            dest.delete();
        return old.renameTo(dest);
    }


    public static boolean getFileByHttp(String url, String filePath, int downloadTimeout){
        logger.info("下载文件：源路径{},目标路径：{}",url,filePath);
        RandomAccessFile raf = null;
        InputStream in = null;

        try {
            URL file_url = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)file_url.openConnection();
            conn.setConnectTimeout(downloadTimeout);
            conn.setRequestMethod("GET");
            File tmpFile = new File(filePath + "_tmp");

            if(tmpFile.exists() && tmpFile.isFile())
                tmpFile.delete();

            int status = conn.getResponseCode();
            long contentLength = conn.getContentLength();
            //chunked为-1
            logger.info("下载请求获得的返回状态码：{},需要下载的大小{}",status,contentLength);
            if(status== 200 || status == 206 ){
                raf = new RandomAccessFile(tmpFile, "rwd");
                in = conn.getInputStream();
                byte[] buffer = new byte[1024];
                int size = 0;
                while((size=in.read(buffer)) !=-1 ){
                    logger.info("正在下载，size:" + size);
                    raf.write(buffer, 0, size);
                }
                raf.close();
                in.close();
                File dest = new File(filePath);
                if(dest.exists() && dest.isFile())
                    dest.delete();
                return tmpFile.renameTo(dest);
            }
        } catch (Throwable e) {
            logger.error("文件下载失败：{}",e.getMessage(),e);
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("getFile关闭异常",e);
                }
            }

        }
        return false;
    }
    public static String postFileByHttp(String url, String filePath,String fileFlag){
        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("logFile", resource);
        param.add("fileName", fileFlag);

        String result = rest.postForObject(url, param, String.class);
        logger.info("上传文件返回信息：" + result);
        return result;
    }

    /**
     * 读取某个文件夹下的所有文件,不包含文件夹
     */
    public static List<File> listFilesUnderPath(String filepath) throws IOException {
        List<File> result = new LinkedList<>();
        File file = new File(filepath);
        if (!file.isDirectory()) {
            logger.info("filepath:" + filepath + "是一个文件");
            return result;
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath  + filelist[i]);
                if (!readfile.isDirectory()) {
                    result.add(readfile);
                }
            }

        }
        return result;
    }


    public static void main(String[] args){
        try {

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }




}
