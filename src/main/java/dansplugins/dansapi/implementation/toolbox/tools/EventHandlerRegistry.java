package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.services.ConfigService;
import dansplugins.dansapi.specification.services.IConfigService;
import dansplugins.dansapi.specification.toolbox.tools.IEventHandlerRegistry;

public class EventHandlerRegistry implements IEventHandlerRegistry {

    private static EventHandlerRegistry instance;

    private EventHandlerRegistry() {

    }

    public static EventHandlerRegistry getInstance() {
        if (instance == null) {
            instance = new EventHandlerRegistry();
        }
        return instance;
    }

    @Override
    public void registerEvents() {
        // TODO: implement
    }
}
