package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.IEventHandlerRegistry;
import dansplugins.dansapi.specification.toolbox.tools.ILogger;

public class Logger implements ILogger {

    private static Logger instance;

    private Logger() {

    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    @Override
    public void log(String message) {
        System.out.println("[" + DansAPI.getInstance().getPlugin().getName() + "] " + message);
    }
}
