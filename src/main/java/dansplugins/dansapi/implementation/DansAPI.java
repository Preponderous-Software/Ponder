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
import org.bukkit.plugin.java.JavaPlugin;

public class DansAPI implements IDansAPI {

    private static DansAPI instance;

    private JavaPlugin plugin;

    private DansAPI() {

    }

    public static DansAPI getInstance() {
        if (instance == null) {
            instance = new DansAPI();
        }
        return instance;
    }

    public void initialize(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public ICommandInterpreter getCommandInterpreter() {
        return CommandInterpreter.getInstance();
    }

    @Override
    public IConfigService getConfigService() {
        return ConfigService.getInstance();
    }

    @Override
    public IStorageService getStorageService() {
        return StorageService.getInstance();
    }

    @Override
    public IToolbox getToolbox() {
        return Toolbox.getInstance();
    }
}
