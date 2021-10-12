package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.services.specification.ICommandService;
import preponderous.ponder.services.specification.IConfigService;
import preponderous.ponder.services.specification.IStorageService;
import preponderous.ponder.specification.IPonderAPI;
import preponderous.ponder.toolbox.Toolbox;
import preponderous.ponder.toolbox.specification.IToolbox;

public class PonderAPI implements IPonderAPI {

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private ICommandService commandInterpreter;
    private IConfigService configService;
    private IStorageService storageService;

    private Toolbox toolbox;

    /**
     * Constructor to initialize the API with a plugin. This should only be used if the developer doesn't plan on using service classes.
     *
     */
    public PonderAPI(JavaPlugin plugin) {
        numInstances++;
        this.plugin = plugin;
        toolbox = new Toolbox(this);

        System.out.println("There are now " + numInstances + " instances of Ponder running.");
    }

    /**
     * Constructor to initialize the API with a plugin as well as associated service classes.
     *
     */
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

    /**
     * Method to get the Command Service
     *
     * @return Command Service
     */
    @Override
    public ICommandService getCommandInterpreter() {
        return commandInterpreter;
    }

    /**
     * Method to get the Config Service
     *
     * @return Config Service
     */
    @Override
    public IConfigService getConfigService() {
        return configService;
    }

    /**
     * Method to get the Storage Service
     *
     * @return Storage Service
     */
    @Override
    public IStorageService getStorageService() {
        return storageService;
    }

    /**
     * Method to get the Toolbox
     *
     * @return Toolbox
     */
    @Override
    public IToolbox getToolbox() {
        return toolbox;
    }

    /**
     * Method to check whether the internal debug flag for the API is enabled.
     *
     * @return Whether or not the debug flag is enabled.
     */
    public boolean isDebugEnabled() {
        return debug;
    }

    /**
     * Method to set the internal debug flag for the API.
     *
     * @param b to set.
     */
    public void setDebug(boolean b) {
        debug = b;
    }
}
