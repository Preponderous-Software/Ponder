package preponderous.ponder.services.specification;

import org.bukkit.command.CommandSender;

public interface ICommandService {
    boolean interpretCommand(CommandSender sender, String label, String[] args);
}
