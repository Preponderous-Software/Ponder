package dansplugins.dansapi.toolbox;

import dansplugins.dansapi.toolbox.tools.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
