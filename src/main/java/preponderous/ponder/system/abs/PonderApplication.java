/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.system.abs;

/**
 * @author Daniel McCoy Stephenson
 * @since January 5th, 2022
 */
public abstract class PonderApplication {
    private String name;
    private String description;

    /**
     * Initializes the application.
     * @param name The name of the application.
     * @param description The description of the application.
     */
    public PonderApplication(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * This method should be called when the application starts.
     */
    public abstract void onStartup();

    /**
     * This method should be called when the application shuts down.
     */
    public abstract void onShutdown();

    /**
     * This method should be called when a command sender sends a command to the application.
     * @param sender The command sender.
     * @param label The label of the command.
     * @param args The arguments of the command.
     * @return Whether the execution of the command was successful.
     */
    public abstract boolean onCommand(CommandSender sender, String label, String[] args);

    /**
     * This can be used to get the name of the application.
     * @return The name of the application.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the application.
     * @param name The new name of the application.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This can be used to get the description of the application.
     * @return The description of the application.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the application.
     * @param description The new description of the application.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}