package pri.yhl.threads.cyclicbarrier;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by yhl on 16-3-15.
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        Map<String,String> info = Collections.synchronizedMap(new TreeMap<String, String>());
        CyclicBarrier barrier = new CyclicBarrier(5,new TotalTask(info));
        new Thread(new SubTask(info,barrier),"subTask-1").start();
        new Thread(new SubTask(info,barrier),"subTask-2").start();
        new Thread(new SubTask(info,barrier),"subTask-3").start();
        new Thread(new SubTask(info,barrier),"subTask-4").start();
        new Thread(new SubTask(info,barrier),"subTask-5").start();

        System.out.println("--------------------分割线------------------");
        TreeMap<Str,String> map = new TreeMap<Str,String>();
        map.put(new Str(1),"value-3");
        map.put(new Str(2),"value-33");
        map.put(new Str(3),"value-5");
        map.put(new Str(4),"value-1");
        map.put(new Str(5),"value-4");
        for(Map.Entry<Str,String> entry: map.entrySet()){
            System.out.println(entry.getKey().toString()+" : "+entry.getValue());
        }



    }
}

class TotalTask implements Runnable{

    private Map<String,String> info = null;

    public TotalTask(Map<String,String> info){
        this.info = info;
    }

    @Override
    public void run() {

        for(Map.Entry<String,String> entry : info.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}

class SubTask implements Runnable{

    private Map<String,String> info = null;
    private CyclicBarrier barrier = null;

    public SubTask(Map<String,String> info,CyclicBarrier barrier){
        this.info = info;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            for(int i=0;i<100000;i++){
                "ers".equals("erf");
            }

        this.info.put(Thread.currentThread().getName(),"try");
        System.out.println(Thread.currentThread().getName()+" is finished!");

            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class Str implements Comparable<Str>{
    private int i=0;
    public Str(int i){
        this.i = i;
    }
    @Override
    public String toString(){

        return String.valueOf(i);
    }
    public int getI(){
        return this.i;
    }

    @Override
    public int compareTo(Str o) {
        if(this.i > o.getI()) {
            return 1;
        } else if(this.i < o.getI()){
            return -1;
        } else{
            return 0;
        }
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }else if(o instanceof Str && ((Str) o).getI() == this.i){
            return true;
        }else{
            return false;
        }
    }
}