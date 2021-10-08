package dansplugins.ponder.implementation.toolbox.tools;

import dansplugins.ponder.specification.toolbox.tools.IPermissionChecker;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

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
