/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.abs;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class AbstractPluginCommand {
    private final ArrayList<String> names;
    private final ArrayList<String> permissions;

    public AbstractPluginCommand(ArrayList<String> names, ArrayList<String> permissions) {
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
     * Method to execute the command with no arguments.
     * @param sender The sender of the command.
     * @param args The arguments of the command.
     * @return Whether the execution of the command was successful.

     */
    public abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Method to drop the first argument from an Array of Strings.
     *
     * @author Daniel McCoy Stephenson
     * @since 10/12/2021
     * @param message to send.
     * @param args to check.
     * @param sender to send message to.
     * @param color of the message.
     * @return Boolean signifying whether there were no arguments.
     */
    public boolean sendMessageIfNoArguments(String message, String[] args, CommandSender sender, ChatColor color) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + message);
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
        } catch (Exception e) {
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
     * Method to get the names that this command can be invoked with.
     * @return A list of names of the command.
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * Method to get the permissions associated with this command.
     * @return A list of permissions of the command.
     */
    public ArrayList<String> getPermissions() {
        return permissions;
    }
}