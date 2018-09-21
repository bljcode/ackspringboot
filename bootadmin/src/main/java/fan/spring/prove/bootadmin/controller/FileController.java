package fan.spring.prove.bootadmin.controller;

import fan.spring.prove.bootadmin.util.UnicodeReader;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by fanlingjie on 2018/9/10.
 */
@RestController
@RequestMapping("/data")
public class FileController {
    //注意这里有的用了GetMapping而不是RequestMapping，只能处理get

    public static String FILE_DIR = null;
    public FileController(){
        try {
            FILE_DIR= ResourceUtils.getURL("classpath:").getPath() + "file/";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 下载文件示例
     */
    @GetMapping("/index")
    public String index(@RequestParam("info") String info)
            throws IOException {
        System.out.println("info:" + info);
        return "OK";
    }


    /**
     * 下载文件示例
     * @param response
     * @throws IOException
     */
    @GetMapping("/sync")
    public void downloadFile(@RequestParam(value="flag") String flag, HttpServletResponse response)
            throws IOException {
        System.out.println("flag:" + flag);
        String filePath =FILE_DIR +  "test.txt";
        File file = new File(filePath);
        if (file.exists()){
            download(file,response);
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("fileName") String fileName,@RequestParam("logFile") MultipartFile logFile) {
        // 下面是测试代码
        System.out.println(fileName);
        String originalFilename = logFile.getOriginalFilename();
        System.out.println(originalFilename);
        BufferedReader bufferedReader = null;
        try {
            //UnicodeReader,用来统一处理带Bom和不带的文件
            bufferedReader = new BufferedReader(new UnicodeReader(logFile.getInputStream(),"UTF-8"));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return "OK";
    }


    protected void  download(File file, HttpServletResponse response){
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());

        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(file.getPath());
            int len = 0;
            byte[] buffer = new byte[1024];
            out = response.getOutputStream();
            while((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }

        }catch(Exception e) {
            throw new RuntimeException(e);
        }finally {
            if(in != null) {
                try {
                    in.close();
                }catch(Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }




}
