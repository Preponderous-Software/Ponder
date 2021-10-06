package dansplugins.dansapi;

import dansplugins.dansapi.commands.ICommandInterpreter;
import dansplugins.dansapi.services.IConfigService;
import dansplugins.dansapi.services.IStorageService;
import dansplugins.dansapi.toolbox.IToolbox;

public interface DansAPI {
    ICommandInterpreter getCommandInterpreter();
    IConfigService getConfigService();
    IStorageService getStorageService();
    IToolbox getToolbox();
}
