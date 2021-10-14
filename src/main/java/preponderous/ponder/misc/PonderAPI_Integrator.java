package preponderous.ponder.misc;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;
import preponderous.ponder.misc.specification.IPonderAPI_Integrator;

public class PonderAPI_Integrator implements IPonderAPI_Integrator {

    private Ponder ponder = null;

    /**
     * Constructor to initialize the API.
     *
     */
    public PonderAPI_Integrator(JavaPlugin plugin) {
        ponder = new Ponder(plugin);
    }

    /**
     * Method to get the instance of the Ponder API that is managed by this class.
     *
     * @return The instance of the Ponder API that is managed by this class.
     */
    @Override
    public Ponder getAPI() {
        return ponder;
    }

}
