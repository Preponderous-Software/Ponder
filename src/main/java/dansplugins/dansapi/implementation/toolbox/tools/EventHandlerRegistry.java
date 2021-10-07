package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.specification.toolbox.tools.IEventHandlerRegistry;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class EventHandlerRegistry implements IEventHandlerRegistry {

    JavaPlugin plugin;

    public EventHandlerRegistry(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void registerEventHandlers(ArrayList<Listener> listeners) {

        PluginManager manager = plugin.getServer().getPluginManager();

        for (Listener listener : listeners) {
            manager.registerEvents(listener, plugin);
        }
    }
}
