package dansplugins.ponder.specification.toolbox;

import dansplugins.ponder.specification.toolbox.tools.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
