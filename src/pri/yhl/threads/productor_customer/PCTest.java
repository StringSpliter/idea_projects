package pri.yhl.threads.productor_customer;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.io.FileNotFoundException;
/**
 * Created by yhl on 2016/8/13.
 */
public class PCTest {
    static boolean isProduct = false;
    public static void main(String args[]) throws InterruptedException {
/*iterator---Collection集合的fail-fast*/
        Set<String> set = new HashSet<String>();
        set.add("as");
        set.add("ad");
        set.add("af");
        set.add("ag");
        set.add("ah");
        Iterator it = set.iterator();

        while(it.hasNext()){
            it.next();
            it.remove();
            set.add("sss");
        }

    }
/*--测试notify与wait--*/
        Object obj = new Object();
//        Productor pro = new Productor(obj);
//        pro.start();;
//        for(int i=0;i<10;i++) {
//            synchronized (obj) {
//                if (isProduct) {
//                    obj.wait();
//                }
//                System.out.println("main thread start to process!");
//                PCTest.isProduct = true;
//                obj.notify();
//            }
//        }
//    }
/*- 测试hashset -*/
//        Productor pro = new Productor(obj);
//        Productor pro1 = new Productor(obj);
//        pro.setI(1);
//        pro1.setI(2);
//        HashSet<Productor> hashSet = new HashSet<Productor>();
//        hashSet.add(pro);
//        hashSet.add(pro1);
/*测试负数二进制表示形式*/
//        int n = 1;
//        int re = ~n+1;
//        System.out.println(re);
/*String*/
//        String str = "adb";
//        try {
//            Field chars= String.class.getDeclaredField("value");
//            chars.setAccessible(true);
//            char[] copy_chars = (char[])chars.get(str);
//            copy_chars[1] = 'b';
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//    }
}
class Productor extends Thread{
    int i = 0;
    Object lock ;
    public Productor(Object lock){
        this.lock = lock;
    }
    @Override
    public void run() {



                try {
                    for(int i=0;i<10;i++) {
                            synchronized(lock){
                            if (!PCTest.isProduct) {
                                lock.wait();
                            }
                            System.out.println("produce thread start to process!");
                                PCTest.isProduct = false;
                            lock.notify();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



    }
    public void setI(int n) {
        this.i = n;
    }
    public int getI(){
        return this.i;
    }
    @Override
    public  int hashCode(){
//        return this.i;
        return this.i;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null|| !(obj instanceof Productor) ) return false;
        else{
            Productor pro = (Productor)obj;
            return pro.getI() == this.i;
        }

    }
}