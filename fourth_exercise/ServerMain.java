package third_lab.fourth_exercise;

import java.io.IOException;

import third_lab.fourth_exercise.lib.Server.Server;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Server server = new Server(4040);
            server.listen();
        } catch (IOException e) {
            System.out.print("Something went wrong: ");
            System.out.println(e.getMessage());
        }
    }
}
