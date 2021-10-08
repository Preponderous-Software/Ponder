package dansplugins.ponder.implementation.toolbox;

import dansplugins.ponder.implementation.PonderAPI;
import dansplugins.ponder.implementation.toolbox.tools.*;
import dansplugins.ponder.specification.toolbox.IToolbox;
import dansplugins.ponder.specification.toolbox.tools.*;

public class Toolbox implements IToolbox {

    private ArgumentParser argumentParser;
    private EventHandlerRegistry eventHandlerRegistry;
    private Logger logger;
    private PermissionChecker permissionChecker;
    private Scheduler scheduler;
    private UUIDChecker uuidChecker;

    public Toolbox(PonderAPI ponderAPI) {
        argumentParser = new ArgumentParser();
        eventHandlerRegistry = new EventHandlerRegistry(ponderAPI);
        logger = new Logger(ponderAPI);
        permissionChecker = new PermissionChecker();
        scheduler = new Scheduler(ponderAPI);
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
