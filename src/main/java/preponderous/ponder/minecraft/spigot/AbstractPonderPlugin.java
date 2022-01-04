package preponderous.ponder.minecraft.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.minecraft.spigot.misc.PonderAPI_Integrator;
import preponderous.ponder.minecraft.spigot.toolbox.Toolbox;

/**
 * @author Daniel Stephenson
 */
public abstract class AbstractPonderPlugin extends JavaPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;
    protected Toolbox toolbox;

    public Ponder getPonderAPI() {
        return ponderAPI_integrator.getAPI();
    }

    public Toolbox getToolbox() {
        return toolbox;
    }

}
