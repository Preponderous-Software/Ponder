package dansplugins.ponder.implementation.toolbox.tools;

import dansplugins.ponder.implementation.PonderAPI;
import dansplugins.ponder.specification.toolbox.tools.IEventHandlerRegistry;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;

public class EventHandlerRegistry implements IEventHandlerRegistry {

    private PonderAPI ponderAPI;

    public EventHandlerRegistry(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    @Override
    public void registerEventHandlers(ArrayList<Listener> listeners) {

        PluginManager manager = ponderAPI.getPlugin().getServer().getPluginManager();

        for (Listener listener : listeners) {
            manager.registerEvents(listener, ponderAPI.getPlugin());
        }
    }
}
