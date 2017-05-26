package pri.yhl.common.set;

import pri.yhl.threads.futuretask.FutureTaskTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by yhl on 16-3-18.
 */
public class MemeryCache {
    public static void main(String[] args){
        FutureTask<Integer> futureTask = new FutureTask(new Task(50));
        FutureTask<Integer> futureTask1 = new FutureTask(new Task(60));
        System.out.println("0 ---  start!");
        futureTask.run();
        System.out.println("1 ---  start!");
        futureTask1.run();

        try {
            System.out.println(futureTask.get());
            System.out.println(futureTask1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class Task implements Callable<Integer>{

    private int i=0;
    public Task(int i){
        this.i = i;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int j=0;j<i;j++){
            sum += j;
        }
        Thread.sleep(5000);
        return Integer.valueOf(sum);
    }
}