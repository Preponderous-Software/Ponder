package dansplugins.ponder.implementation;

import dansplugins.ponder.specification.IPonderAPI_Integrator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PonderAPI_Integrator implements IPonderAPI_Integrator {

    private PonderAPI ponderAPI = null;

    public PonderAPI_Integrator(JavaPlugin plugin) {
        if (isDansAPIPresent()) {
            System.out.println("Dan's API was found successfully!");
            ponderAPI = new PonderAPI(plugin);
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
    public PonderAPI getAPI() {
        return ponderAPI;
    }

}
