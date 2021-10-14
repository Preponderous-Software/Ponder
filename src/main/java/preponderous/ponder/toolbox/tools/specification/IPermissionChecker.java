package preponderous.ponder.toolbox.tools.specification;

import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public interface IPermissionChecker {
    boolean checkPermission(CommandSender sender, String permission);
    boolean checkPermission(CommandSender sender, ArrayList<String> permissions);
}
