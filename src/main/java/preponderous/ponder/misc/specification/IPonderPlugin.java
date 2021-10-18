package preponderous.ponder.misc.specification;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import preponderous.ponder.Ponder;
import preponderous.ponder.toolbox.specification.IToolbox;

public interface IPonderPlugin {
    boolean isDebugEnabled();
    boolean isVersionMismatched();
    Ponder getPonderAPI();
    IToolbox getToolbox();
    String getVersion();
    boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
}