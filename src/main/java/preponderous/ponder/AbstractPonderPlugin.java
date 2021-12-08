package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.misc.PonderAPI_Integrator;
import preponderous.ponder.toolbox.Toolbox;

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
