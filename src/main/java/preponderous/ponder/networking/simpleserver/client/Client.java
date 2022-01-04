package preponderous.ponder.networking.simpleserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Daniel Stephenson
 */
public class Client {
    private String hostName = null;
    private int portNumber = -1;
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public Client(String host, int port) {
        hostName = host;
        portNumber = port;
        initializeSocket();
        initializeReader();
        initializeWriter();
    }

    public String sendAndReceive(String s) {
        sendStringToServer(s);
        return getStringFromServer();
    }

    public void sendStringToServer(String s) {
        out.println(s);
    }

    public String getStringFromServer() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong when getting a string from the server.");
            return null;
        }
    }

    public void disconnect() {
        sendStringToServer("END_OF_CONNECTION");
    }

    private boolean initializeSocket() {
        try {
            socket = new Socket(hostName, portNumber);
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing the socket with port " + portNumber + ".");
            return false;
        }
    }

    private boolean initializeWriter() {
        if (checkIfSocketIsNull()) {
            return false;
        }
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing writer.");
            return false;
        }
    }

    private boolean initializeReader() {
        if (checkIfSocketIsNull()) {
            return false;
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing reader.");
            return false;
        }
    }

    private boolean checkIfSocketIsNull() {
        if (socket == null) {
            System.out.println("Socket is null.");
            return true;
        }
        return false;
    }
}