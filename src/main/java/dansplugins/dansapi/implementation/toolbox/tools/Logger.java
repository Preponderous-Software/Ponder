package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.ILogger;
import org.bukkit.plugin.java.JavaPlugin;

public class Logger implements ILogger {

    @Override
    public void log(String message) {
        JavaPlugin plugin = DansAPI.getInstance().getPlugin();
        if (plugin == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        if (DansAPI.getInstance().isDebugEnabled()) {
            System.out.println("[" + plugin.getName() + "] " + message);
        }
    }

    @Override
    public void print(String message) {
        JavaPlugin plugin = DansAPI.getInstance().getPlugin();
        if (plugin == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        System.out.println("[" + plugin.getName() + "] " + message);
    }
}
