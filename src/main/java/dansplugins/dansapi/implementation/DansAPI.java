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

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private CommandInterpreter commandInterpreter;
    private ConfigService configService;
    private StorageService storageService;
    private Toolbox toolbox;

    public DansAPI(JavaPlugin plugin) {
        numInstances++;
        this.plugin = plugin;
        commandInterpreter = new CommandInterpreter();
        configService = new ConfigService(this);
        storageService = new StorageService();
        toolbox = new Toolbox(this);

        System.out.println("There are now " + numInstances + " instances of Dan's API running.");
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

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

    public boolean isDebugEnabled() {
        return debug;
    }

    public void setDebug(boolean b) {
        debug = b;
    }
}
