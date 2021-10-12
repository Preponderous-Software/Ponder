package preponderous.ponder.toolbox.tools.specification;

import org.bukkit.command.CommandSender;

public interface IPermissionChecker {
    boolean checkPermission(CommandSender sender, String permission);
}
