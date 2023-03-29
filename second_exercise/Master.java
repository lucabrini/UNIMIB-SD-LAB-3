package third_lab.second_exercise;

import java.util.Scanner;

public class Master {
    public static void main(String args[]) {
        Slave slave = new Slave();
        slave.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String slaveMessage = scanner.nextLine();
            if (slaveMessage.equals("fine")) {
                slave.interrupt();
                break;
            }
        }
        scanner.close();
    }
}
