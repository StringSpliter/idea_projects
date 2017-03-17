package pri.yhl.charset;

import java.io.*;

/**
 * Created by yhl on 16-4-16.
 */
public class CharSetExchange {
    public static void main(String args[]) throws IOException {
        Reader is = new FileReader("log.txt");
//        String srcStr= "这事个测试！";
        char[] srcBytes = new char[1];//srcStr.getBytes(Charset.forName("utf-8"));
        int i=1;
	int j = 0;

        while((i=is.read(srcBytes))>0){
            System.out.print(srcBytes);
        }

//        System.out.println("原始值："+srcStr);
//        String tafterEx = new String(srcBytes,Charset.forName("ISO8859-1"));
//
//        String afterEx = new String(tafterEx.getBytes(Charset.forName("ISO8859-1")),Charset.forName("utf-8"));
//
//        System.out.println("转换后:"+afterEx);

    }
}
