package dansplugins.dansapi.implementation.toolbox;

import dansplugins.dansapi.implementation.toolbox.tools.*;
import dansplugins.dansapi.specification.toolbox.IToolbox;
import dansplugins.dansapi.specification.toolbox.tools.*;

public class Toolbox implements IToolbox {

    private ArgumentParser argumentParser = new ArgumentParser();
    private EventHandlerRegistry eventHandlerRegistry = new EventHandlerRegistry();
    private Logger logger = new Logger();
    private PermissionChecker permissionChecker = new PermissionChecker();
    private Scheduler scheduler = new Scheduler();
    private UUIDChecker UUIDChecker = new UUIDChecker();

    @Override
    public IArgumentParser getArgumentParser() {
        return argumentParser;
    }

    @Override
    public IEventHandlerRegistry getEventHandlerRegistry() {
        return eventHandlerRegistry;
    }

    @Override
    public ILogger getLogger() {
        return logger;
    }

    @Override
    public IPermissionChecker getPermissionChecker() {
        return permissionChecker;
    }

    @Override
    public IScheduler getScheduler() {
        return scheduler;
    }

    @Override
    public IUUIDChecker getUUIDChecker() {
        return UUIDChecker;
    }
}
