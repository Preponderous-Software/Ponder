package dansplugins.ponder.implementation;

import dansplugins.ponder.implementation.commands.CommandInterpreter;
import dansplugins.ponder.implementation.services.ConfigService;
import dansplugins.ponder.implementation.services.StorageService;
import dansplugins.ponder.implementation.toolbox.Toolbox;
import dansplugins.ponder.specification.IPonderAPI;
import dansplugins.ponder.specification.commands.ICommandInterpreter;
import dansplugins.ponder.specification.services.IConfigService;
import dansplugins.ponder.specification.services.IStorageService;
import dansplugins.ponder.specification.toolbox.IToolbox;
import org.bukkit.plugin.java.JavaPlugin;

public class PonderAPI implements IPonderAPI {

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private CommandInterpreter commandInterpreter;
    private ConfigService configService;
    private StorageService storageService;
    private Toolbox toolbox;

    public PonderAPI(JavaPlugin plugin) {
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
