package third_lab.first_exercise;

public class Main {

    public static final int THREADS_NUMBER = 3;

    public static void main(String args[]) {

        SharedObject object = new SharedObject();

        BasicThread threads[] = new BasicThread[THREADS_NUMBER];
        for (int i = 0; i < THREADS_NUMBER; i++) {
            threads[i] = new BasicThread("thread-" + i, object);
        }

        for (int i = 0; i < THREADS_NUMBER; i++) {
            new Thread(threads[i]).start();
        }
    }
}
