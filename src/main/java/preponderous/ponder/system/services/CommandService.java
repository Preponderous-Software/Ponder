/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.system.services;

import preponderous.ponder.misc.ArgumentParser;
import preponderous.ponder.system.abs.ApplicationCommand;
import preponderous.ponder.system.abs.CommandSender;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniel McCoy Stephenson
 * @since January 5th, 2022
 */
public class CommandService {
    private final Set<ApplicationCommand> commands;
    private final ArgumentParser argumentParser = new ArgumentParser();

    /**
     * @param commands The commands to instantiate the service with.
     */
    public CommandService(HashSet<ApplicationCommand> commands) {
        this.commands = commands;
    }

    /**
     * @param sender The sender of the command.
     * @param label The label of the command.
     * @param args The arguments of the command.
     */
    public boolean interpretAndExecuteCommand(CommandSender sender, String label, String[] args) {
        for (ApplicationCommand command : commands) {
            if (commandCanBeInvokedWithLabel(command, label)) {
                return executeCommand(sender, command, args);
            }
        }
        sender.sendMessage("That command wasn't found.");
        return false;
    }

    /**
     * @param command The command to check.
     * @param label The label to use to check.
     * @return Whether the command can be invoked with the passed label.
     */
    private boolean commandCanBeInvokedWithLabel(ApplicationCommand command, String label) {
        return command.getNames().contains(label);
    }

    /**
     * @param sender The sender of the command.
     * @param command The command to invoke.
     * @param args The arguments of the command.
     * @return Whether the invocation of the command was successful.
     */
    private boolean executeCommand(CommandSender sender, ApplicationCommand command, String[] args) {
        if (args.length == 0) {
            return command.execute(sender);
        }
        else {
            return command.execute(sender, args);
        }
    }
}