package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.IEventHandlerRegistry;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;

public class EventHandlerRegistry implements IEventHandlerRegistry {

    private DansAPI dansAPI;

    public EventHandlerRegistry(DansAPI dansAPI) {
        this.dansAPI = dansAPI;
    }

    @Override
    public void registerEventHandlers(ArrayList<Listener> listeners) {

        PluginManager manager = dansAPI.getPlugin().getServer().getPluginManager();

        for (Listener listener : listeners) {
            manager.registerEvents(listener, dansAPI.getPlugin());
        }
    }
}
