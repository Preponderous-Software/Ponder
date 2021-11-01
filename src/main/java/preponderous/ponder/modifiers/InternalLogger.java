package preponderous.ponder.modifiers;

/**
 * @author Daniel Stephenson
 */
public interface InternalLogger {

    boolean debug = true;

    /**
     * Method to set the internal debug flag for the class.
     *
     * @param b boolean to set.
     */
    void setDebug(boolean b);

    /**
     * Method to print a message to the console if the debug flag is set to true.
     *
     * @param   message to print.
     * @return {@link boolean} signifying whether or not the method was successful.
     */
    default boolean log(String message) {
        if (debug) {
            System.out.println("[Ponder] " + message);
            return true;
        }
        return false;
    }

}