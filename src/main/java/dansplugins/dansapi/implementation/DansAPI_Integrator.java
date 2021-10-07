package dansplugins.dansapi.implementation;

import dansplugins.dansapi.specification.IDansAPI_Integrator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DansAPI_Integrator implements IDansAPI_Integrator {

    private DansAPI dansAPI = null;

    public DansAPI_Integrator(JavaPlugin plugin) {
        if (isDansAPIPresent()) {
            System.out.println("Dan's API was found successfully!");
            dansAPI = new DansAPI(plugin);
        }
        else {
            System.out.println("Dan's API was not found!");
        }
    }

    @Override
    public boolean isDansAPIPresent() {
        return (Bukkit.getServer().getPluginManager().getPlugin("DansAPI") != null);
    }

    @Override
    public DansAPI getAPI() {
        return dansAPI;
    }

}
