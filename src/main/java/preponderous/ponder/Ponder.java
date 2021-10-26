package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.services.CommandService;
import preponderous.ponder.services.ConfigService;
import preponderous.ponder.services.LocaleService;
import preponderous.ponder.services.StorageService;
import preponderous.ponder.toolbox.Toolbox;

/**
 * @author Daniel Stephenson
 */
public class Ponder {

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private CommandService commandService;
    private ConfigService configService;
    private LocaleService localeService;
    private StorageService storageService;

    private Toolbox toolbox;

    private String version = "v0.7-alpha-1";

    /**
     * Constructor to initialize the API.
     *
     * @param plugin    JavaPlugin to initialize the API with.
     */
    public Ponder(JavaPlugin plugin) {
        numInstances++;
        this.plugin = plugin;
        toolbox = new Toolbox(this);
        configService = new ConfigService(this);
        storageService = new StorageService();
        commandService = new CommandService(this);
        localeService = new LocaleService(this);

        System.out.println("There are now " + numInstances + " instances of Ponder running.");
    }

    /**
     * Method to get the plugin that the API has been instantiated with.
     *
     * @return {@link JavaPlugin}
     */
    public JavaPlugin getPlugin() {
        return plugin;
    }

    /**
     * Method to get the Command Service
     *
     * @return {@link CommandService}
     */
    public CommandService getCommandService() {
        return commandService;
    }

    /**
     * Method to get the Config Service
     *
     * @return {@link ConfigService}
     */
    public ConfigService getConfigService() {
        return configService;
    }

    /**
     * Method to get the Locale Service
     *
     * @return {@link LocaleService}
     */
    public LocaleService getLocaleService() {
        return localeService;
    }

    /**
     * Method to get the Storage Service
     *
     * @return {@link StorageService}
     */
    public StorageService getStorageService() {
        return storageService;
    }

    /**
     * Method to get the Toolbox
     *
     * @return {@link Toolbox}
     */
    public Toolbox getToolbox() {
        return toolbox;
    }

    /**
     * Method to check whether the internal debug flag for the API is enabled.
     *
     * @return Boolean signifying whether the debug flag is enabled.
     */
    public boolean isDebugEnabled() {
        return debug;
    }

    /**
     * Method to set the internal debug flag for the API.
     *
     * @param b boolean to set.
     */
    public void setDebug(boolean b) {
        debug = b;
    }

    /**
     * Method to get the version of the API.
     *
     * @return The version of the API as a {@link String}.
     */
    public String getVersion() {
        return version;
    }
}
