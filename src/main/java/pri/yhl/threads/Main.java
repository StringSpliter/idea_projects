package pri.yhl.threads;

/**
 * Created by yhl on 17-8-30.
 */
public class Main {

    public static void main(String[] args) {
        QueueBuffer q = new QueueBuffer();
        new Producter(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }

}
