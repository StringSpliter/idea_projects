package pri.yhl.threads.curVector;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool;

import java.util.Vector;
/**
 * Created by yhl on 16-3-6.
 */
public class CurDemoOfVector {

    public static void main(String[] args){

        Vector<IntSub> vector = new Vector<IntSub>();

        new Thread(new CurVectorAdd<IntSub>(vector)).start();
        new Thread(new CurVectorDel<IntSub>(vector),"Thread-01").start();
        new Thread(new CurVectorDel<IntSub>(vector),"Thread-02").start();
        new Thread(new CurVectorDel<IntSub>(vector),"Thread-03").start();
        new Thread(new CurVectorDel<IntSub>(vector),"Thread-04").start();
    }

}

class CurVectorDel<E extends Int> implements Runnable{

    Vector<E> vector = null;

    public CurVectorDel(Vector<E> vector){
        this.vector = vector;
    }

    @Override
    public void run() {

        while(true) {
            synchronized (vector) {
                if (!vector.isEmpty()) {
                    int lastIndex = vector.size()-1;
//                try {
//                    Thread.sleep(10);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                    System.out.println(Thread.currentThread().getName()+"::::::"+vector.get(lastIndex));
                    vector.remove(lastIndex);
                }
            }
        }

    }

}
class CurVectorAdd<E extends Int> implements Runnable{

    Vector<E> vector = null;

    private static volatile int i = 0;
    private static Object lock = new Object();

    public CurVectorAdd(Vector<E> vector){
        this.vector = vector;
    }

    @Override
    public void run(){
        while(i != 1000) {
            synchronized (lock) {
                synchronized (vector) {
                    vector.add((E) new Int(i++));
                }
            }
        }

    }
}

class Int{
    protected  int n=0;
    public Int(){

    }
    public Int(int i){
        n = i;
    }
}

class IntSub extends Int{
    public IntSub(){

    }
}
