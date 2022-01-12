/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.spigot.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.minecraft.abs.AbstractPluginCommand;
import preponderous.ponder.minecraft.spigot.PonderMC;
import preponderous.ponder.minecraft.spigot.tools.PermissionChecker;
import preponderous.ponder.misc.ArgumentParser;

import java.util.ArrayList;
import java.util.Set;

/**
 * @author Daniel McCoy Stephenson
 */
public class CommandService {
    private ArrayList<AbstractPluginCommand> commands = new ArrayList<>();
    private final Set<String> coreCommands;
    private String notFoundMessage;
    private final ArgumentParser parser = new ArgumentParser();
    private final PermissionChecker permissionChecker = new PermissionChecker();

    public CommandService(PonderMC ponder) {
        coreCommands = ponder.getPlugin().getDescription().getCommands().keySet();
    }

    /**
     * Method to initialize the command service.
     *
     */
    public void initialize(ArrayList<AbstractPluginCommand> commands, String notFoundMessage) {
        this.commands = commands;
        this.notFoundMessage = notFoundMessage;
    }

    /**
     * Method to interpret and execute a command.
     *
     */
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        if (!coreCommands.contains(label)) {
            return false;
        }

        if (args.length == 0) {
            return false;
        }

        String subCommand = args[0];

        String[] arguments = parser.dropFirstArgument(args);

        for (AbstractPluginCommand command : commands) {
            if (command.getNames().contains(subCommand)) {
                if (!permissionChecker.checkPermission(sender, command.getPermissions())) {
                    return false;
                }
                if (arguments.length == 0) {
                    return command.execute(sender);
                }
                else {
                    return command.execute(sender, arguments);
                }
            }
        }
        sender.sendMessage(ChatColor.RED + notFoundMessage);
        return false;
    }

}
