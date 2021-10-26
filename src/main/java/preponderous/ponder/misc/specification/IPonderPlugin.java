package preponderous.ponder.misc.specification;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import preponderous.ponder.Ponder;
import preponderous.ponder.toolbox.Toolbox;

public interface IPonderPlugin {
    boolean isDebugEnabled();
    boolean isVersionMismatched();
    Ponder getPonderAPI();
    Toolbox getToolbox();
    String getVersion();
    boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
}