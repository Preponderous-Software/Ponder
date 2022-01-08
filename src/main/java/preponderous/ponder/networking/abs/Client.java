package preponderous.ponder.networking.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class Client {
    private final String host;
    private final int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        initializeSocket();
        initializeReader();
        initializeWriter();
    }

    public String sendAndReceive(String s) {
        sendStringToServer(s);
        return getStringFromServer();
    }

    public void sendStringToServer(String s) {
        getOut().println(s);
    }

    public String getStringFromServer() {
        try {
            return getIn().readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong when getting a string from the server.");
            return null;
        }
    }

    public void disconnect() {
        sendStringToServer("END_OF_CONNECTION");
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    private void initializeSocket() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing the socket with port " + port + ".");
        }
    }

    private void initializeWriter() {
        if (checkIfSocketIsNull()) {
            return;
        }
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing writer.");
        }
    }

    private void initializeReader() {
        if (checkIfSocketIsNull()) {
            return;
        }
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Something went wrong when initializing reader.");
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