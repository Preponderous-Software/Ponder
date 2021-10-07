package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.ILogger;
import org.bukkit.plugin.java.JavaPlugin;

public class Logger implements ILogger {

    private DansAPI dansAPI;

    public Logger(DansAPI dansAPI) {
        this.dansAPI = dansAPI;
    }

    @Override
    public void log(boolean debug, String message) {
        if (dansAPI.getPlugin() == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        if (debug) {
            System.out.println("[" + dansAPI.getPlugin().getName() + "] " + message);
        }
    }

    @Override
    public void print(String message) {
        if (dansAPI.getPlugin() == null) {
            System.out.println("Error: Plugin was null.");
            return;
        }
        System.out.println("[" + dansAPI.getPlugin().getName() + "] " + message);
    }
}
