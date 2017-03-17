package pri.yhl.threads.interrupt;

/**
 * Created by yhl on 16-4-5.
 */
public class InterruptTest {
    public static volatile boolean door = false;


    public static void main(String[] args){
        final  Monitor s = new Monitor();
        Task1 t1 = new Task1(s);
        Task2 t2 = new Task2(s);
        Thread threat = new Thread(t2);

        Thread threa = new Thread(t1);
        threat.start();
        threa.start();
//        threa.interrupt();

    }
}

class Task1 implements Runnable {

    private Monitor s =null;

    public  Task1(Monitor s){
        this.s = s;
    }

    @Override
    public void run() {
        try {
            while(true) {
                synchronized (s) {
                    System.out.println("wait s!");
                    if(InterruptTest.door) {
                        InterruptTest.door = false;
                        s.wait();
                    }
                    else {
                        InterruptTest.door = true;
                        s.notifyAll();
                    }
                    System.out.println("wait s close!");

                }
            }
        } catch (InterruptedException e) {
            System.out.println("Current thread is interrupted!");
            e.printStackTrace();
        }
    }
}


class Task2 implements Runnable {

    private Monitor s =null;
    public  Task2(Monitor s){
        this.s = s;
    }


    @Override
    public void run() {
        try {
            while(true) {
                synchronized(s) {

                        System.out.println("thread sleep start!");
                        if(InterruptTest.door) {
                            InterruptTest.door = false;
                            s.wait();
                        }
                        else {
                            InterruptTest.door = true;
                            s.notifyAll();
                        }
                        System.out.println("thread sleep close!");
//                        Thread.sleep(5000);

                    }
            }
        } catch (Exception e) {
            System.out.println("Current thread is interrupted!");
            e.printStackTrace();
        }
    }
}

class Monitor{
    public synchronized void getN(){
        System.out.println("getN");
    }
}