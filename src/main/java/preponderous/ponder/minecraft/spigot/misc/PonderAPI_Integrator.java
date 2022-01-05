package preponderous.ponder.minecraft.spigot.misc;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;

/**
 * @author Daniel Stephenson
 */
public class PonderAPI_Integrator {

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
    public Ponder getAPI() {
        return ponder;
    }

}
