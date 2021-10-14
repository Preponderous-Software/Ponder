package preponderous.ponder.toolbox.tools;

import preponderous.ponder.PonderAPI;
import preponderous.ponder.toolbox.tools.specification.ILogger;

public class Logger implements ILogger {

    private PonderAPI ponderAPI;

    public Logger(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    /**
     * Method to print a message to the console if the debug flag is set to true.
     *
     * @param debug to check.
     * @param message to print.
     * @return {@link boolean} signifying whether or not the method was successful.
     */
    @Override
    public boolean log(boolean debug, String message) {
        if (ponderAPI.getPlugin() == null) {
            System.out.println("Error: Plugin was null.");
            return false;
        }
        if (debug) {
            System.out.println("[" + ponderAPI.getPlugin().getName() + "] " + message);
            return true;
        }
        return false;
    }

    /**
     * Method to print a message to the console.
     *
     * @param message to print.
     */
    @Override
    public void print(String message) {
        if (ponderAPI.getPlugin() == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        System.out.println("[" + ponderAPI.getPlugin().getName() + "] " + message);
    }
}
