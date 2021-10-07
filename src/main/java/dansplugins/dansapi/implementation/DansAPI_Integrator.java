package dansplugins.dansapi.implementation;

import dansplugins.dansapi.implementation.toolbox.tools.Logger;
import dansplugins.dansapi.specification.IDansAPI_Integrator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DansAPI_Integrator implements IDansAPI_Integrator {

    private static DansAPI_Integrator instance;

    private DansAPI dansAPI = null;
    private JavaPlugin plugin = null;

    public DansAPI_Integrator(JavaPlugin plugin) {
        if (isDansAPIPresent()) {
            initialize(plugin);
            Logger.getInstance().print("Dan's API was found successfully!");
            dansAPI = DansAPI.getInstance();
        }
        else {
            Logger.getInstance().print("Dan's API was not found!");
        }
    }

    @Override
    public void initialize(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean isDansAPIPresent() {
        return (Bukkit.getServer().getPluginManager().getPlugin("DansAPI") != null);
    }

    @Override
    public DansAPI getAPI(JavaPlugin plugin) {
        dansAPI.initialize(plugin);
        return dansAPI;
    }

    @Override
    public DansAPI getAPI() {
        dansAPI.initialize(plugin);
        return dansAPI;
    }

}
