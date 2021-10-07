package dansplugins.dansapi.specification.toolbox.tools;

import org.bukkit.event.Listener;

import java.util.ArrayList;

public interface IEventHandlerRegistry {
    void registerEventHandlers(ArrayList<Listener> listeners);
}
