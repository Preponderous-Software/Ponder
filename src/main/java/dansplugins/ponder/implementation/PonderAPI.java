package dansplugins.ponder.implementation;

import dansplugins.ponder.implementation.toolbox.Toolbox;
import dansplugins.ponder.specification.IPonderAPI;
import dansplugins.ponder.specification.services.ICommandService;
import dansplugins.ponder.specification.services.IConfigService;
import dansplugins.ponder.specification.services.IStorageService;
import dansplugins.ponder.specification.toolbox.IToolbox;
import org.bukkit.plugin.java.JavaPlugin;

public class PonderAPI implements IPonderAPI {

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private ICommandService commandInterpreter;
    private IConfigService configService;
    private IStorageService storageService;

    private Toolbox toolbox;

    public PonderAPI(JavaPlugin plugin) {
        numInstances++;
        this.plugin = plugin;
        toolbox = new Toolbox(this);

        System.out.println("There are now " + numInstances + " instances of Ponder running.");
    }

    public PonderAPI(JavaPlugin plugin, ICommandService commandInterpreter, IConfigService configService, IStorageService storageService) {
        numInstances++;
        this.plugin = plugin;
        this.commandInterpreter = commandInterpreter;
        this.configService = configService;
        this.storageService = storageService;
        toolbox = new Toolbox(this);

        System.out.println("There are now " + numInstances + " instances of Ponder running.");
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    public ICommandService getCommandInterpreter() {
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
