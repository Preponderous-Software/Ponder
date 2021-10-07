package dansplugins.dansapi.implementation;

import dansplugins.dansapi.commands.ICommandInterpreter;
import dansplugins.dansapi.services.IConfigService;
import dansplugins.dansapi.services.IStorageService;
import dansplugins.dansapi.specification.IDansAPI;
import dansplugins.dansapi.toolbox.IToolbox;

public class DansAPI implements IDansAPI {

    @Override
    public ICommandInterpreter getCommandInterpreter() {
        // TODO: implement
        return null;
    }

    @Override
    public IConfigService getConfigService() {
        // TODO: implement
        return null;
    }

    @Override
    public IStorageService getStorageService() {
        // TODO: implement
        return null;
    }

    @Override
    public IToolbox getToolbox() {
        // TODO: implement
        return null;
    }
}
