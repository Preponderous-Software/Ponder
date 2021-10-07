package dansplugins.dansapi.implementation.commands;

import dansplugins.dansapi.implementation.services.StorageService;
import dansplugins.dansapi.specification.commands.ICommandInterpreter;
import dansplugins.dansapi.specification.services.IStorageService;
import org.bukkit.command.CommandSender;

public class CommandInterpreter implements ICommandInterpreter {

    private static CommandInterpreter instance;

    private CommandInterpreter() {

    }

    public static CommandInterpreter getInstance() {
        if (instance == null) {
            instance = new CommandInterpreter();
        }
        return instance;
    }

    @Override
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        // TODO: implement
        return false;
    }
}
