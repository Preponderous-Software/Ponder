package preponderous.ponder.system.example.commands;

import preponderous.ponder.system.abs.AbstractCommand;
import preponderous.ponder.system.abs.AbstractCommandSender;

import java.util.ArrayList;

public class DefaultCommand extends AbstractCommand {

    public DefaultCommand(ArrayList<String> names, ArrayList<String> permissions) { // TODO: alter
        super(names, permissions);
    }

    @Override
    public boolean execute(AbstractCommandSender sender) {
        // TODO: implement
        return false;
    }

    @Override
    public boolean execute(AbstractCommandSender sender, String[] args) {
        // TODO: implement
        return false;
    }
}
