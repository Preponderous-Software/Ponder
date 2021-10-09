package dansplugins.ponder.implementation;

import org.bukkit.plugin.java.JavaPlugin;

public class Ponder extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Ponder is enabling.");
    }

    public void onDisable() {
        System.out.println("Ponder is disabling.");
    }

    public PonderAPI getAPI(JavaPlugin plugin) {
        return new PonderAPI(plugin);
    }

    public PonderAPI_Integrator getIntegrator(JavaPlugin plugin) {
        return new PonderAPI_Integrator(plugin);
    }

}
