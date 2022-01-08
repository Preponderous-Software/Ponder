package preponderous.ponder;

/**
 * @author Daniel Stephenson
 * @since 10/12/2021
 */
public class Ponder {
    private boolean debug = false;

    private String version = "v0.13-alpha-2";

    /**
     * Constructor to initialize the API for general purposes.
     */
    public Ponder() {

    }

    /**
     * Method to check whether the internal debug flag for the API is enabled.
     *
     * @return Boolean signifying whether the debug flag is enabled.
     */
    public boolean isDebugEnabled() {
        return debug;
    }

    /**
     * Method to get the version of the API.
     *
     * @return The version of the API as a {@link String}.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Method to set the internal debug flag for the class.
     *
     * @param b boolean to set.
     */
    public void setDebug(boolean b) {
        debug = b;
    }

    /**
     * Method to log a message if debug is set to true.
     * @param message to log.
     * @return boolean signifying success
     */
    public boolean log(String message) {
        if (debug) {
            System.out.println("[Ponder] " + message);
            return true;
        }
        return false;
    }
}