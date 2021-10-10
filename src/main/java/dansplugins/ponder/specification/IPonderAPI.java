package dansplugins.ponder.specification;


import dansplugins.ponder.specification.services.ICommandService;
import dansplugins.ponder.specification.services.IConfigService;
import dansplugins.ponder.specification.services.IStorageService;
import dansplugins.ponder.specification.toolbox.IToolbox;

public interface IPonderAPI {
    ICommandService getCommandInterpreter();
    IConfigService getConfigService();
    IStorageService getStorageService();
    IToolbox getToolbox();
    boolean isDebugEnabled();
    void setDebug(boolean b);
}
