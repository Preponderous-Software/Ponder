package dansplugins.dansapi.implementation.toolbox;

import dansplugins.dansapi.implementation.services.ConfigService;
import dansplugins.dansapi.implementation.toolbox.tools.*;
import dansplugins.dansapi.specification.services.IConfigService;
import dansplugins.dansapi.specification.toolbox.IToolbox;
import dansplugins.dansapi.specification.toolbox.tools.*;

public class Toolbox implements IToolbox {

    private static Toolbox instance;

    public static Toolbox getInstance() {
        if (instance == null) {
            instance = new Toolbox();
        }
        return instance;
    }

    @Override
    public IArgumentParser getArgumentParser() {
        return ArgumentParser.getInstance();
    }

    @Override
    public IEventHandlerRegistry getEventHandlerRegistry() {
        return EventHandlerRegistry.getInstance();
    }

    @Override
    public ILogger getLogger() {
        return Logger.getInstance();
    }

    @Override
    public IPermissionChecker getPermissionChecker() {
        return PermissionChecker.getInstance();
    }

    @Override
    public IScheduler getScheduler() {
        return Scheduler.getInstance();
    }

    @Override
    public IUUIDChecker getUUIDChecker() {
        return UUIDChecker.getInstance();
    }
}
