package preponderous.ponder.toolbox.specification;

import preponderous.ponder.toolbox.tools.specification.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IColorChecker getColorChecker();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
