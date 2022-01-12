/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.system.abs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daniel McCoy Stephenson
 * @since January 5th, 2022
 *
 * @author Callum Johnson
 */
public abstract class ApplicationCommand {
    private ArrayList<String> names = null;
    private ArrayList<String> permissions = null;

    public ApplicationCommand(ArrayList<String> names, ArrayList<String> permissions) {
        this.names = names;
        this.permissions = permissions;
    }

    /**
     * Method to execute the command with no arguments.
     * @param sender The sender of the command.
     * @return Whether the execution of the command was successful.
     */
    public abstract boolean execute(CommandSender sender);

    /**
     * Method to execute the command with arguments.
     * @param sender The sender of the command.
     * @param args The arguments of the command.
     * @return Whether the execution of the command was successful.
     */
    public abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Method to send a message to a command sender if there are arguments.
     *
     * @author Daniel McCoy Stephenson
     * @since 10/12/2021
     * @param message The message to send.
     * @param args The arguments to check.
     * @param sender The sender of the command that we will be sending the message to.
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

    /**
     * This can be used to access the names of the command.
     * @return A list of the names of the command.
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getPermissions() {
        return permissions;
    }
}