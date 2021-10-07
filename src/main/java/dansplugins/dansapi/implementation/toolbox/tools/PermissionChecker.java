package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.specification.toolbox.tools.ILogger;
import dansplugins.dansapi.specification.toolbox.tools.IPermissionChecker;
import org.bukkit.command.CommandSender;

public class PermissionChecker implements IPermissionChecker {

    private static PermissionChecker instance;

    private PermissionChecker() {

    }

    public static PermissionChecker getInstance() {
        if (instance == null) {
            instance = new PermissionChecker();
        }
        return instance;
    }

    @Override
    public boolean checkPermission(CommandSender sender, String permission) {
        // TODO: implement
        return false;
    }
}
