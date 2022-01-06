package preponderous.ponder.system.example;

import preponderous.ponder.system.abs.AbstractCommandSender;
import preponderous.ponder.system.abs.AbstractPonderApplication;

/**
 * @author Daniel Stephenson
 * @since January 5th, 2022
 */
public class ExamplePonderApplication extends AbstractPonderApplication {

    public ExamplePonderApplication() {
        super("ExamplePonderApplication", "An example of an application that utilizes Ponder.");
    }

    @Override
    public void onStartup() {
        // TODO: implement
    }

    @Override
    public void onShutdown() {
        // TODO: implement
    }

    @Override
    public boolean onCommand(AbstractCommandSender sender, String label, String[] args) {
        return false;
    }
}