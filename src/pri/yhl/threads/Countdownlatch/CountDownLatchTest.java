package pri.yhl.threads.Countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yhl on 16-3-15.
 */

public class CountDownLatchTest {
    public static void main(String args[]){
        int n = 10;
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(n);

        for( int i = 0 ; i <  n ; i++ ){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        System.out.println(Thread.currentThread().getName());
                        for(int j =0 ; j < 10000 ; j++){
                            "sds".equals(j);
                        };
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        endGate.countDown();
                    }
                }
            },"Thread-"+i).start();
        }

        for(int i =0 ; i<100000 ;i++ ){
            "ehduhdi".equals("ehduhd");

        }
        System.out.println("start job is finished!");
        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is the last job!");

    }
}