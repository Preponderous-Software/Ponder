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
        setPortNumber(port);
        initializeServerSocket();
    }

    public abstract void createNewServerThread();

    public void start() {
        setListening(true);

        while (isListening()) {
            System.out.println("Listening for a new connection...");
            createNewServerThread();
        }
    }

    public void stop() {
        setListening(false);
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }

    public boolean isListening() {
        return listening;
    }

    private void initializeServerSocket() {
        try {
            setServerSocket(new ServerSocket(portNumber));
        } catch (IOException e) {
            System.out.println("Something went wrong while initializing with port " + getPortNumber() + "!");
        }
    }
}