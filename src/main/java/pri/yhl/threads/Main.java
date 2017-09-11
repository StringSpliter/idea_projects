package pri.yhl.threads;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yhl on 17-8-30.
 */
public class Main {

    public static void main(String[] args) {
        int a =26,b=10;
        System.out.println(a&b);
//        QueueBuffer q = new QueueBuffer();
//        new Producter(q);
//        new Consumer(q);
//        System.out.println("Press Control-C to stop.");
        ExecutorService es = Executors.newCachedThreadPool();
//        es.
    }

}
