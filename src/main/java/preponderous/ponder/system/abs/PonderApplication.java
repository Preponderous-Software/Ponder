package preponderous.ponder.system.abs;

/**
 * @author Daniel McCoy Stephenson
 * @since January 5th, 2022
 */
public abstract class PonderApplication {
    private String name;
    private String description;

    public PonderApplication(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void onStartup();

    public abstract void onShutdown();

    public abstract boolean onCommand(CommandSender sender, String label, String[] args);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}