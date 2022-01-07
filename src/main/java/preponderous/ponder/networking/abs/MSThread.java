package preponderous.ponder.networking.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author Daniel Stephenson
 */
public abstract class MSThread extends Thread {
    private final Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String inputLine;
    private String outputLine;

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

            if (getOutputLine().equals("END_OF_CONNECTION")) {
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

    public abstract void processInput();

    public Socket getSocket() {
        return socket;
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

    public String getInputLine() {
        return inputLine;
    }

    public void setInputLine(String inputLine) {
        this.inputLine = inputLine;
    }

    public String getOutputLine() {
        return outputLine;
    }

    public void setOutputLine(String outputLine) {
        this.outputLine = outputLine;
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

    private void sendResponseToClient() {
        out.println(outputLine);
    }
}