package preponderous.ponder.toolbox;

import preponderous.ponder.PonderAPI;
import preponderous.ponder.toolbox.specification.IToolbox;
import preponderous.ponder.toolbox.tools.*;
import preponderous.ponder.toolbox.tools.specification.*;

public class Toolbox implements IToolbox {

    private ArgumentParser argumentParser;
    private ColorChecker colorChecker;
    private EventHandlerRegistry eventHandlerRegistry;
    private Logger logger;
    private PermissionChecker permissionChecker;
    private Scheduler scheduler;
    private UUIDChecker uuidChecker;

    /**
     * Constructor to initialize the tools of the toolbox.
     *
     */
    public Toolbox(PonderAPI ponderAPI) {
        argumentParser = new ArgumentParser();
        colorChecker = new ColorChecker();
        eventHandlerRegistry = new EventHandlerRegistry(ponderAPI);
        logger = new Logger(ponderAPI);
        permissionChecker = new PermissionChecker();
        scheduler = new Scheduler(ponderAPI);
        uuidChecker = new UUIDChecker();
    }

    /**
     * Method to drop the get the argument parser tool.
     *
     * @return Argument Parser
     */
    @Override
    public IArgumentParser getArgumentParser() {
        return argumentParser;
    }

    /**
     * Method to drop the get the color checker tool.
     *
     * @return Color Checker
     */
    @Override
    public IColorChecker getColorChecker() {
        return colorChecker;
    }

    /**
     * Method to drop the get the event handler registry tool.
     *
     * @return Event Handler Registry
     */
    @Override
    public IEventHandlerRegistry getEventHandlerRegistry() {
        return eventHandlerRegistry;
    }

    /**
     * Method to drop the get the logger tool.
     *
     * @return Logger
     */
    @Override
    public ILogger getLogger() {
        return logger;
    }

    /**
     * Method to drop the get the permission checker tool.
     *
     * @return Permission Checker
     */
    @Override
    public IPermissionChecker getPermissionChecker() {
        return permissionChecker;
    }

    /**
     * Method to drop the get the scheduler tool.
     *
     * @return Scheduler
     */
    @Override
    public IScheduler getScheduler() {
        return scheduler;
    }

    /**
     * Method to drop the UUID Checker tool.
     *
     * @return UUID Checker
     */
    @Override
    public IUUIDChecker getUUIDChecker() {
        return uuidChecker;
    }
}
