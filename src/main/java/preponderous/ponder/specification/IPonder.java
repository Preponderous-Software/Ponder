package preponderous.ponder.specification;


import preponderous.ponder.services.specification.ICommandService;
import preponderous.ponder.services.specification.IConfigService;
import preponderous.ponder.services.specification.ILocaleService;
import preponderous.ponder.services.specification.IStorageService;
import preponderous.ponder.toolbox.specification.IToolbox;

public interface IPonder {
    ICommandService getCommandService();
    IConfigService getConfigService();
    ILocaleService getLocaleService();
    IStorageService getStorageService();
    IToolbox getToolbox();
    boolean isDebugEnabled();
    void setDebug(boolean b);
}
