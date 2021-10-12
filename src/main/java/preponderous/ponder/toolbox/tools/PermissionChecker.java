package preponderous.ponder.toolbox.tools;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.toolbox.tools.specification.IPermissionChecker;

public class PermissionChecker implements IPermissionChecker {

    @Override
    public boolean checkPermission(CommandSender sender, String permission) {
        if (!sender.hasPermission(permission)) {
            sender.sendMessage(ChatColor.RED + "In order to use this command, you need the following permission: '" + permission + "'");
            return false;
        }
        return true;
    }

}
