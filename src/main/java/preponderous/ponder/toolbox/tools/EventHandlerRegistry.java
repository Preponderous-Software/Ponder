package preponderous.ponder.toolbox.tools;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.toolbox.tools.specification.IEventHandlerRegistry;

import java.util.ArrayList;

public class EventHandlerRegistry implements IEventHandlerRegistry {

    private final PluginManager manager;
    private PonderAPI ponderAPI;

    public EventHandlerRegistry(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
        this.manager = Bukkit.getPluginManager();
    }

    /**
     * Method to register multiple listeners for a given plugin.
     *
     * @param listeners to register.
     * @param plugin to register it for.
     * @throws IllegalArgumentException if the arguments are invalid.
     */
    @Override
    public void registerEventHandlers(ArrayList<Listener> listeners, Plugin plugin) {
        if (listeners == null || listeners.isEmpty()) throw new IllegalArgumentException("Listeners cannot be null or empty!");
        if (plugin == null) throw new IllegalArgumentException("Plugin cannot be null!");
        listeners.forEach(listener -> manager.registerEvents(listener, plugin));
    }

}
