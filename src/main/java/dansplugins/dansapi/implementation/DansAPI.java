package dansplugins.dansapi.implementation;

import dansplugins.dansapi.implementation.commands.CommandInterpreter;
import dansplugins.dansapi.implementation.services.ConfigService;
import dansplugins.dansapi.implementation.services.StorageService;
import dansplugins.dansapi.implementation.toolbox.Toolbox;
import dansplugins.dansapi.implementation.toolbox.tools.Logger;
import dansplugins.dansapi.specification.IDansAPI;
import dansplugins.dansapi.specification.commands.ICommandInterpreter;
import dansplugins.dansapi.specification.services.IConfigService;
import dansplugins.dansapi.specification.services.IStorageService;
import dansplugins.dansapi.specification.toolbox.IToolbox;
import org.bukkit.plugin.java.JavaPlugin;

public class DansAPI extends JavaPlugin implements IDansAPI {

    private static DansAPI instance;

    private JavaPlugin plugin;

    private boolean debug = true;

    int timesInitialized = 0;

    public static DansAPI getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    public void initialize(JavaPlugin plugin) {
        timesInitialized++;
        System.out.println("Dan's API has been initialized " + timesInitialized + " times.");
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

    @Override
    public boolean isDebugEnabled() {
        return debug;
    }

    @Override
    public void setDebug(boolean b) {
        debug = b;
    }
}
