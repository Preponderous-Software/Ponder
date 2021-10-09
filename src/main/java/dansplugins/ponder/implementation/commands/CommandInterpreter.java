package dansplugins.ponder.implementation.commands;

import dansplugins.ponder.implementation.PonderAPI;
import dansplugins.ponder.specification.commands.ICommandInterpreter;
import org.bukkit.command.CommandSender;

public class CommandInterpreter implements ICommandInterpreter {

    private PonderAPI ponderAPI;

    public CommandInterpreter(PonderAPI dansAPI) {
        this.ponderAPI = dansAPI;
    }

    @Override
    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        // TODO: implement
        return false;
    }
}
