package pri.yhl.threads.tomcat;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * Created by yhl on 16-4-3.
 */
public class ExecutorServiceTest {

//    private final static  ExecutorService exeS =null;
//    static{
//        exeS = new
//    }
    static private volatile int n = 0;
    public static void main(String[] args){
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                while(n<10000){
                    "SDSDFDFF".equals("SDSDFD");
                }
                System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssss"+(n++));

            }
        },1000,1000);
        time.schedule(new TimerTask() {
            @Override
            public void run() {

                while(n<10000){
                    "SDSDFDFF".equals("SDSDFD");
                }
                System.out.println("ddddddddddddddddddddddddddddddddddddddddddddddddd"+(n++));

            }
        },1000,1000);
        Timer time2 = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2222222222222222222222222222222222222222222");

            }
        },1000,5000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
                try {
                    Thread.currentThread().sleep(20000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ExecutorServiceTest.n = 10001;
                System.out.println("end!");
            }
        }).start();
    }
}
