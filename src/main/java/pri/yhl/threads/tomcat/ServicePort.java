package pri.yhl.threads.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by yhl on 16-3-30.
 */
public class ServicePort {
    private static final int poolSize = 3;
    private static  Executor exe = Executors.newFixedThreadPool(poolSize);

    public static  void main(String[] args) throws IOException {
        ServerSocket socke = new ServerSocket(8061);
        while(true){
            final Socket childS  = socke.accept();
            Runnable s = new Runnable() {

                @Override
                public void run() {
                    try {
                        InputStream out = childS.getInputStream();
                        Reader w = new InputStreamReader(out);
                        int i=0;
                        char [] a = new char[10];
                        while((i = w.read(a))!=-1){
                            int j=0;
                            while(j<i){
                                System.out.println(a[j]);
                                j++;
                            }
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            childS.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            exe.execute(s);
        }
    }

}
