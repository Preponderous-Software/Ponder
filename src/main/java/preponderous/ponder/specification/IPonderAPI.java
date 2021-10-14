package preponderous.ponder.specification;


import preponderous.ponder.services.specification.ICommandService;
import preponderous.ponder.services.specification.IConfigService;
import preponderous.ponder.services.specification.ILocaleService;
import preponderous.ponder.services.specification.IStorageService;
import preponderous.ponder.toolbox.specification.IToolbox;

public interface IPonderAPI {
    ICommandService getCommandService();
    IConfigService getConfigService();
    IStorageService getStorageService();
    ILocaleService getLocaleService();
    IToolbox getToolbox();
    boolean isDebugEnabled();
    void setDebug(boolean b);
}
