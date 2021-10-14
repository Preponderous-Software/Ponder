package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.services.CommandService;
import preponderous.ponder.services.ConfigService;
import preponderous.ponder.services.StorageService;
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

    private ICommandService commandService;
    private IConfigService configService;
    private IStorageService storageService;

    private Toolbox toolbox;

    private String version = "v0.5-alpha-1";

    /**
     * Constructor to initialize the API.
     *
     */
    public PonderAPI(JavaPlugin plugin) {
        numInstances++;
        this.plugin = plugin;
        toolbox = new Toolbox(this);
        configService = new ConfigService(this);
        storageService = new StorageService();
        commandService = new CommandService(this);

        System.out.println("There are now " + numInstances + " instances of Ponder running.");
    }

    /**
     * Method to get the plugin that the API has been instantiated with.
     *
     * @return JavaPlugin
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Method to get the Command Service
     *
     * @return Command Service
     */
    @Override
    public ICommandService getCommandService() {
        return commandService;
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

    /**
     * Method to get the version of the API.
     *
     * @return The version of the API.
     */
    public String getVersion() {
        return version;
    }
}
