package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.ILogger;
import org.bukkit.plugin.java.JavaPlugin;

public class Logger implements ILogger {

    JavaPlugin plugin;

    public Logger(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void log(boolean debug, String message) {
        if (plugin == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        if (debug) {
            System.out.println("[" + plugin.getName() + "] " + message);
        }
    }

    @Override
    public void print(String message) {
        if (plugin == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        System.out.println("[" + plugin.getName() + "] " + message);
    }
}
