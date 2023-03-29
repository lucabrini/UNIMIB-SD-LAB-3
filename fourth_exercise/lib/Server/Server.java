package third_lab.fourth_exercise.lib.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket socket;
    private int serverPort;

    public Server(int port) throws IOException {
        this.serverPort = port;
        this.socket = new ServerSocket(port);
    }

    public void listen() throws IOException {
        System.out.println("Server listening on port: " + this.serverPort);
        while (true) {
            Socket clientSocket = this.socket.accept();
            (new RequestHandler(clientSocket)).start();
        }
    }
}
