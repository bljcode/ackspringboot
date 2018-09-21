package fan.spring.prove.bootadmin;

import java.io.*;

/**
 * Created by fanlingjie on 2018/9/18.
 */
public class Test {

    public static void main(String[] args) throws Exception {

        //另总得来说流要注意关闭,reader是依赖stream，所以也要关闭
        File file = new File("D:/test.txt");
        //stream之类属于字节流,reader之类属于字符流
        FileInputStream fileInputStream = new FileInputStream(file);//可以file也可以直接文件地址"D:/test.txt"
        //stream读入等操作一般需要借助字节数组
        byte[] buffer = new byte[50];
        fileInputStream.read(buffer,0,10);//这里应该循环读至-1
        System.out.print(new String(buffer));


        //InputStreamReader 是一个连接字节流和字符流的桥梁，它将字节流转变为字符流，字符流一般调用read reanline ,无数据返回-1
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        //FileReader extends InputStreamReader,是由字节流实现的,
        // 在其中使用了使用了将FileInputStream 转变为Reader 的方法
        FileReader fileReader = new FileReader(file);
        //是否需要缓冲提高效率，是就加上Buffered
        //BufferedReader由其他reader构造，装饰模式装饰其他reader,并对其添加字符缓冲器
        BufferedReader test = new BufferedReader(fileReader);

        /* 补充一个文件操作相关的：
        java普通的文件读取方式对于bom是无法正常识别的。
        使用普通的InputStreamReader，如果采用的编码正确，那么可以获得正确的字符，但bom仍然附带在结果中，很容易导致数据处理出错。
        另外，对于存在BOM头的文件，无法猜测它使用的编码。
         参考地址：http://koti.mbnet.fi/akini/java/unicodereader/， 下载其中两个文件：UnicodeStream和UnicodeReader*/


    }


    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; ++i){

        }



        return true;
    }


}
