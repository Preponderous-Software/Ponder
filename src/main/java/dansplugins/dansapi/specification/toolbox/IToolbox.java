package dansplugins.dansapi.specification.toolbox;

import dansplugins.dansapi.specification.toolbox.tools.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
