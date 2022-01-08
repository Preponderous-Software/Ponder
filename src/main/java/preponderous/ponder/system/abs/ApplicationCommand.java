package preponderous.ponder.system.abs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daniel Stephenson
 * @since January 5th, 2022
 */
public abstract class ApplicationCommand {
    private ArrayList<String> names = null;
    private ArrayList<String> permissions = null;

    public ApplicationCommand(ArrayList<String> names, ArrayList<String> permissions) {
        this.names = names;
        this.permissions = permissions;
    }

    public abstract boolean execute(CommandSender sender);

    public abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Method to drop the first argument from an Array of Strings.
     *
     * @author Daniel Stephenson
     * @since 10/12/2021
     * @param message to send.
     * @param args to check.
     * @param sender to send message to..
     * @return Boolean signifying whether there were no arguments.
     */
    public boolean sendMessageIfNoArguments(String message, String[] args, CommandSender sender) {
        if (args.length == 0) {
            sender.sendMessage(message);
            return true;
        }
        return false;
    }

    /**
     * Method to get an Integer from a String.
     *
     * @author Callum Johnson
     * @since 05/05/2021 - 12:18
     * @param line to convert into an Integer.
     * @param orElse if the conversion fails.
     * @return {@link Integer} numeric.
     */
    public int getIntSafe(String line, int orElse) {
        try {
            return Integer.parseInt(line);
        } catch (Exception ex) {
            return orElse;
        }
    }

    /**
     * Method to test if something matches any goal string.
     *
     * @author Callum Johnson
     * @since 05/05/2021 - 12:18
     * @param what to test
     * @param goals to compare with
     * @param matchCase for the comparison (or not)
     * @return {@code true} if something in goals matches what.
     */
    public boolean safeEquals(boolean matchCase, String what, String... goals) {
        return Arrays.stream(goals).anyMatch(goal ->
                matchCase && goal.equals(what) || !matchCase && goal.equalsIgnoreCase(what)
        );
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }
}