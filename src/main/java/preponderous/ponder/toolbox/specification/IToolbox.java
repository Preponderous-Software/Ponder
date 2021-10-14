package preponderous.ponder.toolbox.specification;

import preponderous.ponder.toolbox.tools.specification.*;

public interface IToolbox {
    IArgumentParser getArgumentParser();
    IBlockChecker getBlockChecker();
    IColorChecker getColorChecker();
    IEventHandlerRegistry getEventHandlerRegistry();
    ILogger getLogger();
    IMessenger getMessenger();
    IPermissionChecker getPermissionChecker();
    IScheduler getScheduler();
    IUUIDChecker getUUIDChecker();
}
