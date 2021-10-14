package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.services.CommandService;
import preponderous.ponder.services.ConfigService;
import preponderous.ponder.services.LocaleService;
import preponderous.ponder.services.StorageService;
import preponderous.ponder.services.specification.ICommandService;
import preponderous.ponder.services.specification.IConfigService;
import preponderous.ponder.services.specification.ILocaleService;
import preponderous.ponder.services.specification.IStorageService;
import preponderous.ponder.specification.IPonder;
import preponderous.ponder.toolbox.Toolbox;
import preponderous.ponder.toolbox.specification.IToolbox;

public class Ponder implements IPonder {

    private boolean debug = true;

    private static int numInstances = 0;

    private JavaPlugin plugin;

    private ICommandService commandService;
    private IConfigService configService;
    private ILocaleService localeService;
    private IStorageService storageService;

    private Toolbox toolbox;

    private String version = "v0.5-alpha-1";

    /**
     * Constructor to initialize the API.
     *
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
    @Override
    public ICommandService getCommandService() {
        return commandService;
    }

    /**
     * Method to get the Config Service
     *
     * @return {@link ConfigService}
     */
    @Override
    public IConfigService getConfigService() {
        return configService;
    }

    /**
     * Method to get the Locale Service
     *
     * @return {@link LocaleService}
     */
    @Override
    public ILocaleService getLocaleService() {
        return localeService;
    }

    /**
     * Method to get the Storage Service
     *
     * @return {@link StorageService}
     */
    @Override
    public IStorageService getStorageService() {
        return storageService;
    }

    /**
     * Method to get the Toolbox
     *
     * @return {@link Toolbox}
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
    @Override
    public boolean isDebugEnabled() {
        return debug;
    }

    /**
     * Method to set the internal debug flag for the API.
     *
     * @param b to set.
     */
    @Override
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
