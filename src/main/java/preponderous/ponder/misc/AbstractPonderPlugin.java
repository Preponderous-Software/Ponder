package preponderous.ponder.misc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;
import preponderous.ponder.misc.specification.IPonderPlugin;
import preponderous.ponder.toolbox.specification.IToolbox;

import java.util.ArrayList;

public abstract class AbstractPonderPlugin extends JavaPlugin implements IPonderPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;
    protected IToolbox toolbox;
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

    public IToolbox getToolbox() {
        return toolbox;
    }

    public String getVersion() {
        return version;
    }

}
