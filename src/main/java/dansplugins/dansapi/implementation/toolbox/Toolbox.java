package dansplugins.dansapi.implementation.toolbox;

import dansplugins.dansapi.implementation.toolbox.tools.*;
import dansplugins.dansapi.specification.toolbox.IToolbox;
import dansplugins.dansapi.specification.toolbox.tools.*;

public class Toolbox implements IToolbox {

    private ArgumentParser argumentParser;
    private EventHandlerRegistry eventHandlerRegistry;
    private Logger logger;
    private PermissionChecker permissionChecker;
    private Scheduler scheduler;
    private UUIDChecker uuidChecker;

    public Toolbox() {
        argumentParser = new ArgumentParser();
        eventHandlerRegistry = new EventHandlerRegistry();
        logger = new Logger();
        permissionChecker = new PermissionChecker();
        scheduler = new Scheduler();
        uuidChecker = new UUIDChecker();
    }

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
        return uuidChecker;
    }
}
