package dansplugins.ponder.specification.toolbox.tools;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public interface IEventHandlerRegistry {
    void registerEventHandlers(ArrayList<Listener> listeners, Plugin plugin);
}
