package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;
import preponderous.ponder.misc.PonderAPI_Integrator;
import preponderous.ponder.toolbox.Toolbox;

public abstract class AbstractPonderPlugin extends JavaPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;
    protected Toolbox toolbox;
    protected String version = "v0.1-alpha-1";

    public boolean isDebugEnabled() {
        return getPonderAPI().getConfigService().getBoolean("debugMode");
    }

    public boolean isVersionMismatched() {
        return !getConfig().getString("version").equalsIgnoreCase(getVersion());
    }

    public Ponder getPonderAPI() {
        return ponderAPI_integrator.getAPI();
    }

    public Toolbox getToolbox() {
        return toolbox;
    }

    public String getVersion() {
        return version;
    }

}
