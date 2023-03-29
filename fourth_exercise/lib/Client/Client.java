package third_lab.fourth_exercise.lib.Client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements Runnable {

    private Socket socket;
    private String name;

    public Client(int port, String name) throws IOException {
        this(InetAddress.getLocalHost(), port, name);
    }

    public Client(InetAddress address, int port, String name) throws IOException {
        this.socket = new Socket(address, port);
        this.name = name;
    }

    private void sendMessage(String message) throws IOException {
        PrintWriter outputStream = new PrintWriter(this.socket.getOutputStream());
        
        outputStream.write(message);
        outputStream.flush();

        System.out.println(this.name + " sent message.");
    }

    @Override
    public void run() {
        try {
            sendMessage(this.name);
            handleReceiveMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleReceiveMessage() throws IOException {

        InputStream socketInputStream = this.socket.getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(socketInputStream);

        byte[] byteArray = new byte[255];
        int messageLength = buffer.read(byteArray);
        String message = new String(byteArray, 0, messageLength);

        if (message.equals(this.name)) {
            System.out.println("Received message from server");
            System.out.println("Terminating " + this.name);
        }
    }

}
