package preponderous.ponder.services.specification;

import org.bukkit.command.CommandSender;
import preponderous.ponder.commands.specification.ICommand;

import java.util.ArrayList;

public interface ICommandService {
    void initialize(ArrayList<ICommand> commands, String coreCommand, String noArgsMessage, String notFoundMessage);
    boolean interpretCommand(CommandSender sender, String label, String[] args);
}
