package preponderous.ponder.system.services;

import preponderous.ponder.misc.ArgumentParser;
import preponderous.ponder.system.abs.AbstractCommand;
import preponderous.ponder.system.abs.AbstractCommandSender;

import java.util.HashSet;

/**
 * @author Daniel Stephenson
 * @since January 5th, 2022
 */
public class CommandService {
    private HashSet<AbstractCommand> commands = new HashSet<>();
    private ArgumentParser parser = new ArgumentParser();

    /**
     * Constructor to initialize the service.
     * @param commands The commands to instantiate the service with.
     */
    public void CommandService(HashSet<AbstractCommand> commands) {
        this.commands = commands;
    }

    /**
     * Method to interpret and execute a command.
     *
     */
    public boolean interpretCommand(AbstractCommandSender sender, String label, String[] args) {
        for (AbstractCommand command : commands) {
            if (command.getNames().contains(label)) {
                if (args.length == 0) {
                    return command.execute(sender);
                }
                else {
                    return command.execute(sender, args);
                }
            }
        }
        sender.sendMessage("That command wasn't found.");
        return false;
    }
}