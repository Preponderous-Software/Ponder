package preponderous.ponder.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.Ponder;
import preponderous.ponder.misc.specification.ICommand;

import java.util.ArrayList;

/**
 * @author Daniel Stephenson
 */
public class CommandService {

    private Ponder ponder;

    private ArrayList<ICommand> commands = new ArrayList<>();
    private String coreCommand;
    private String noArgsMessage;
    private String notFoundMessage;

    public CommandService(Ponder ponder) {
        this.ponder = ponder;
    }

    /**
     * Method to initialize the command service.
     *
     */
    public void initialize(ArrayList<ICommand> commands, String coreCommand, String noArgsMessage, String notFoundMessage) {
        this.commands = commands;
        this.coreCommand = coreCommand;
        this.noArgsMessage = noArgsMessage;
        this.notFoundMessage = notFoundMessage;
    }

    /**
     * Method to interpret and execute a command.
     *
     */
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        ponder.log("Attempting to interpret command with label: " + label);
        if (!label.equalsIgnoreCase(coreCommand)) {
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + noArgsMessage);
            return true;
        }

        String subCommand = args[0];
        ponder.log("Sub-command: " + subCommand);

        String[] arguments = ponder.getToolbox().getArgumentParser().dropFirstArgument(args);

        for  (ICommand command : commands) {
            if (command.getNames().contains(subCommand)) {
                if (!ponder.getToolbox().getPermissionChecker().checkPermission(sender, command.getPermissions())) {
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
