package dansplugins.dansapi.specification;

import dansplugins.dansapi.commands.ICommandInterpreter;
import dansplugins.dansapi.services.IConfigService;
import dansplugins.dansapi.services.IStorageService;
import dansplugins.dansapi.toolbox.IToolbox;

public interface IDansAPI {
    ICommandInterpreter getCommandInterpreter();
    IConfigService getConfigService();
    IStorageService getStorageService();
    IToolbox getToolbox();
}
