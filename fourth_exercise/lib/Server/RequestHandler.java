package third_lab.fourth_exercise.lib.Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler extends Thread {

    Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("New client connected:");
        System.out.println("\t- PORT:" + this.clientSocket.getPort());
        System.out.println("\t- ADDRESS:" + this.clientSocket.getInetAddress());

        String messageFromClient = "";

        try {
            messageFromClient = handleReceiveMessage();

            System.out.println("\t- New message:");
            System.out.println("\t\t- ADDRESS:" + this.clientSocket.getInetAddress());
            System.out.println("\t\t- MESSAGE: " + messageFromClient);

            handleResponseMessage(messageFromClient);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\tFinished handling " + messageFromClient + " request. Terminating thread...");
        interrupt();
    }

    public String handleReceiveMessage() throws IOException {
        InputStream socketInputStream = this.clientSocket.getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(socketInputStream);

        byte[] byteArray = new byte[255];
        int messageLength = buffer.read(byteArray);

        return new String(byteArray, 0, messageLength);
    }

    public void handleResponseMessage(String response) throws IOException {
        PrintWriter outputStream = new PrintWriter(this.clientSocket.getOutputStream());
        
        outputStream.write(response);
        outputStream.flush();
        outputStream.close();
    }
}
