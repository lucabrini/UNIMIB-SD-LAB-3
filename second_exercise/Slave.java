package third_lab.second_exercise;

public class Slave extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("ciao");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("termino");
        }
    }
}
