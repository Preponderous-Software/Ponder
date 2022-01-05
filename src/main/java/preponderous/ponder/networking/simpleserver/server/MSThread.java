package preponderous.ponder.networking.simpleserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author Daniel Stephenson
 */
public class MSThread extends Thread {
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private String inputLine;
    private String outputLine;

    private Protocol protocol;

    public MSThread(Socket s) {
        super("MultiServerThread");
        socket = s;
        initializeWriter();
        initializeReader();
    }

    public void run() {
        while (readNextLine()) {
            processInput();
            sendResponseToClient();

            if (outputLine.equals("END_OF_CONNECTION")) {
                disconnect();
                break;
            }
        }
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean initializeWriter() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean initializeReader() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean readNextLine() {
        try {
            return (inputLine = in.readLine()) != null;
        } catch (SocketException e) {
            System.out.println("Could not read next line. Client has disconnected.");
            return false;
        } catch (IOException e) {
            System.out.println("Could not read next line. IO Exception.");
            return false;
        }
    }

    private void processInput() {
        outputLine = protocol.processInput(inputLine);
    }

    private void sendResponseToClient() {
        out.println(outputLine);
    }
}