package preponderous.ponder.system.services;

import preponderous.ponder.misc.ArgumentParser;
import preponderous.ponder.system.abs.AbstractCommand;
import preponderous.ponder.system.abs.AbstractCommandSender;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Daniel Stephenson
 * @since January 5th, 2022
 */
public class CommandService {
    private HashSet<AbstractCommand> commands = new HashSet<>();
    private Set<String> coreCommands;
    private ArgumentParser parser = new ArgumentParser();

    public CommandService(Set<String> coreCommands) {
        this.coreCommands = coreCommands;
    }

    public void initialize(HashSet<AbstractCommand> commands) {
        this.commands = commands;
    }

    /**
     * Method to interpret and execute a command.
     *
     */
    public boolean interpretCommand(AbstractCommandSender sender, String label, String[] args) {
        if (!coreCommands.contains(label)) {
            return false;
        }

        if (args.length == 0) {
            return false;
        }

        String subCommand = args[0];

        String[] arguments = parser.dropFirstArgument(args);

        for (AbstractCommand command : commands) {
            if (command.getNames().contains(subCommand)) {
                if (arguments.length == 0) {
                    return command.execute(sender);
                }
                else {
                    return command.execute(sender, arguments);
                }
            }
        }
        sender.sendMessage("That command wasn't found.");
        return false;
    }
}