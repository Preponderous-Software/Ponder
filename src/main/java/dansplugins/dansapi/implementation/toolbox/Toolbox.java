package dansplugins.dansapi.implementation.toolbox;

import dansplugins.dansapi.specification.toolbox.IToolbox;
import dansplugins.dansapi.specification.toolbox.tools.*;

public class Toolbox implements IToolbox {

    @Override
    public IArgumentParser getArgumentParser() {
        // TODO: implement
        return null;
    }

    @Override
    public IEventHandlerRegistry getEventHandlerRegistry() {
        // TODO: implement
        return null;
    }

    @Override
    public ILogger getLogger() {
        // TODO: implement
        return null;
    }

    @Override
    public IPermissionChecker getPermissionChecker() {
        // TODO: implement
        return null;
    }

    @Override
    public IScheduler getScheduler() {
        // TODO: implement
        return null;
    }

    @Override
    public IUUIDChecker getUUIDChecker() {
        // TODO: implement
        return null;
    }
}
