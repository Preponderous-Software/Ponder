package preponderous.ponder.minecraft.abs;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.minecraft.spigot.PonderMC;
import preponderous.ponder.minecraft.spigot.misc.PonderAPI_Integrator;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class PonderPlugin extends JavaPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;

    public PonderMC getPonderAPI() {
        return ponderAPI_integrator.getAPI();
    }
}