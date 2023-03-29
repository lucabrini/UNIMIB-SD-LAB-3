package third_lab.fourth_exercise;

import java.io.IOException;

import third_lab.fourth_exercise.lib.Client.Client;

public class ClientMain {
    public final static int CLIENT_NUMBER = 4;

    public static void main(String args[]) {
        Client[] clients = new Client[CLIENT_NUMBER];

        for (int i = 0; i < CLIENT_NUMBER; i++) {
            try {

                String threadName = "client-thread-" + i;
                clients[i] = new Client(4040, threadName);

                System.out.println("Spawned " + threadName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < CLIENT_NUMBER; i++) {
            new Thread(clients[i]).start();
        }
    }
}
