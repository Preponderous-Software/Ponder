package preponderous.ponder.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.Ponder;
import preponderous.ponder.misc.specification.ICommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * @author Daniel Stephenson
 */
public class CommandService {

    private Ponder ponder;

    private ArrayList<ICommand> commands = new ArrayList<>();
    private Set<String> coreCommands;
    private String noArgsMessage;
    private String notFoundMessage;

    public CommandService(Ponder ponder) {
        this.ponder = ponder;
        coreCommands = ponder.getPlugin().getDescription().getCommands().keySet();
    }

    /**
     * Method to initialize the command service.
     *
     */
    public void initialize(ArrayList<ICommand> commands, String noArgsMessage, String notFoundMessage) {
        this.commands = commands;
        this.noArgsMessage = noArgsMessage;
        this.notFoundMessage = notFoundMessage;
    }

    /**
     * Method to interpret and execute a command.
     *
     */
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        ponder.log("Attempting to interpret command with label: " + label);
        if (!coreCommands.contains(label)) {
            ponder.log("Command didn't match one of the core commands. Aborting.");
            return false;
        }

        if (args.length == 0) {
            ponder.log("No arguments were given.");
            sender.sendMessage(ChatColor.AQUA + noArgsMessage);
            return true;
        }

        String subCommand = args[0];
        ponder.log("Sub-command: " + subCommand);

        String[] arguments = ponder.getToolbox().getArgumentParser().dropFirstArgument(args);
        ponder.log("Arguments: " + Arrays.toString(arguments));

        for  (ICommand command : commands) {
            ponder.log("Checking command " + command.getNames().get(0));
            if (command.getNames().contains(subCommand)) {
                if (!ponder.getToolbox().getPermissionChecker().checkPermission(sender, command.getPermissions())) {
                    ponder.log("The sender doesn't have permission to run this command.");
                    return false;
                }
                if (arguments.length == 0) {
                    ponder.log("Executing with no additional arguments.");
                    return command.execute(sender);
                }
                else {
                    ponder.log("Executing with additional arguments.");
                    return command.execute(sender, arguments);
                }
            }
        }
        ponder.log("The sub-command wasn't recognized.");
        sender.sendMessage(ChatColor.RED + notFoundMessage);
        return false;
    }

}
