package preponderous.ponder.misc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.services.specification.ICommandService;
import preponderous.ponder.services.specification.IConfigService;
import preponderous.ponder.services.specification.IStorageService;
import preponderous.ponder.specification.IPonderAPI_Integrator;

public class PonderAPI_Integrator implements IPonderAPI_Integrator {

    private PonderAPI ponderAPI = null;

    /**
     * Constructor to initialize the API.
     *
     */
    public PonderAPI_Integrator(JavaPlugin plugin) {
        ponderAPI = new PonderAPI(plugin);
    }

    /**
     * Method to get the instance of the Ponder API that is managed by this class.
     *
     * @return The instance of the Ponder API that is managed by this class.
     */
    @Override
    public PonderAPI getAPI() {
        return ponderAPI;
    }

}
