package dansplugins.dansapi.specification;

import dansplugins.dansapi.implementation.DansAPI;
import org.bukkit.plugin.java.JavaPlugin;

public interface IDansAPI_Integrator {
    void initialize(JavaPlugin plugin);
    boolean isDansAPIPresent();
    DansAPI getAPI(JavaPlugin plugin);
    DansAPI getAPI();
}
