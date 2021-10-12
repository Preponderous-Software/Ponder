package preponderous.ponder.toolbox.specification;

import preponderous.ponder.toolbox.tools.specification.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
