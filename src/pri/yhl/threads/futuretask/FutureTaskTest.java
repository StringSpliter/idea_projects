package pri.yhl.threads.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by yhl on 16-3-8.
 */
public class FutureTaskTest {
    public static void main(String args[]){
        FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer> (){

            @Override
            public Integer call() throws Exception {
                int sum=0;
                for(int i=0;i<100;i++){
                    Thread.sleep(100);
                    sum=sum+i;
                }
                System.out.println(Thread.currentThread().getName());
                return sum;
            }
        });

        new Thread(future,"first").start();
        int result = 0 ;
        try {
            result = future.get();
            System.out.println(result+"sd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            System.out.println(result);
        }
    }
}
