package preponderous.ponder.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.commands.specification.ICommand;
import preponderous.ponder.services.specification.ICommandService;

import java.util.ArrayList;

public class CommandService implements ICommandService {

    private PonderAPI ponderAPI;

    private ArrayList<ICommand> commands = new ArrayList<>();
    private String coreCommand;
    private String noArgsMessage;
    private String notFoundMessage;

    public CommandService(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    @Override
    public void initialize(ArrayList<ICommand> commands, String coreCommand, String noArgsMessage, String notFoundMessage) {
        this.commands = commands;
        this.coreCommand = coreCommand;
        this.noArgsMessage = noArgsMessage;
        this.notFoundMessage = notFoundMessage;
    }

    @Override
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        if (!label.equalsIgnoreCase(coreCommand)) {
            return false;
        }

        if (args.length == 0) {
            sender.sendMessage(ChatColor.AQUA + noArgsMessage);
            return true;
        }

        String subCommand = args[0];
        String[] arguments = ponderAPI.getToolbox().getArgumentParser().dropFirstArgument(args);

        for  (ICommand command : commands) {
            if (command.getNames().contains(subCommand)) {
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
