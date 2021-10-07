package dansplugins.dansapi.implementation.toolbox;

import dansplugins.dansapi.implementation.DansAPI;
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

    public Toolbox(DansAPI dansAPI) {
        argumentParser = new ArgumentParser();
        eventHandlerRegistry = new EventHandlerRegistry(dansAPI);
        logger = new Logger(dansAPI);
        permissionChecker = new PermissionChecker();
        scheduler = new Scheduler(dansAPI);
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
