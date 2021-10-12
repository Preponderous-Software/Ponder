package preponderous.ponder.toolbox.tools.specification;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public interface IEventHandlerRegistry {
    void registerEventHandlers(ArrayList<Listener> listeners, Plugin plugin);
}
