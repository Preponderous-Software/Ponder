package preponderous.ponder.minecraft.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;
import preponderous.ponder.minecraft.spigot.misc.PonderAPI_Integrator;

/**
 * @author Daniel Stephenson
 */
public abstract class AbstractPonderPlugin extends JavaPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;

    public Ponder getPonderAPI() {
        return ponderAPI_integrator.getAPI();
    }
}