package dansplugins.dansapi.implementation;

import dansplugins.dansapi.implementation.commands.CommandInterpreter;
import dansplugins.dansapi.implementation.services.ConfigService;
import dansplugins.dansapi.implementation.services.StorageService;
import dansplugins.dansapi.implementation.toolbox.Toolbox;
import dansplugins.dansapi.specification.IDansAPI;
import dansplugins.dansapi.specification.commands.ICommandInterpreter;
import dansplugins.dansapi.specification.services.IConfigService;
import dansplugins.dansapi.specification.services.IStorageService;
import dansplugins.dansapi.specification.toolbox.IToolbox;

public class DansAPI implements IDansAPI {

    private CommandInterpreter commandInterpreter = new CommandInterpreter();
    private ConfigService configService = new ConfigService();
    private StorageService storageService = new StorageService();
    private Toolbox toolbox = new Toolbox();

    @Override
    public ICommandInterpreter getCommandInterpreter() {
        return commandInterpreter;
    }

    @Override
    public IConfigService getConfigService() {
        return configService;
    }

    @Override
    public IStorageService getStorageService() {
        return storageService;
    }

    @Override
    public IToolbox getToolbox() {
        return toolbox;
    }
}
