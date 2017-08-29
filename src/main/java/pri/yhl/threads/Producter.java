package pri.yhl.threads;

/**
 * Created by yhl on 17-8-30.
 */
public class Producter implements Runnable {

    private QueueBuffer q;

    Producter(QueueBuffer q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}
