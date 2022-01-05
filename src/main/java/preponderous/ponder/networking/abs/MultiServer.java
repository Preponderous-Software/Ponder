package preponderous.ponder.networking.abs;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Daniel Stephenson
 */
public abstract class MultiServer {
    private int portNumber = -1;
    private ServerSocket serverSocket = null;
    private boolean listening = false;

    public MultiServer(int port) {
        portNumber = port;
        initializeServerSocket();
    }

    public void start() {
        listening = true;

        while (isListening()) {
            System.out.println("Listening for a new connection...");
            createNewServerThread();
        }
    }

    public void stop() {
        listening = false;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public boolean isListening() {
        return listening;
    }

    public abstract boolean createNewServerThread();

    private boolean initializeServerSocket() {
        try {
            serverSocket = new ServerSocket(portNumber);
            return true;
        } catch (IOException e) {
            System.out.println("Something went wrong while initializing with port " + getPortNumber() + "!");
            return false;
        }
    }
}