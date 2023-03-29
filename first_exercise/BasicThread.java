package third_lab.first_exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicThread implements Runnable {

    public static final int LOOP_MAX = 2;
    public static Lock lock = new ReentrantLock();

    private String name;
    private SharedObject object;

    public BasicThread(String name, SharedObject object) {
        this.name = name;
        this.object = object;
    }

    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < LOOP_MAX; i++) {
                System.out.println("- NUM_WRITE: " + object.getNumWrite());

                object.incrementNumWrite();
                object.setLastWriter(this.name);

                System.out.println("- LAST_WRITER: " + object.getLastWriter());
                System.out.println("- NUM_WRITE: " + object.getNumWrite());
                System.out.println("-------------");
            }
            Thread.sleep(3000);
            lock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
