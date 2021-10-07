package dansplugins.dansapi.specification.toolbox.tools;

import org.bukkit.command.CommandSender;

public interface IPermissionChecker {
    boolean checkPermission(CommandSender sender, String permission);
}
