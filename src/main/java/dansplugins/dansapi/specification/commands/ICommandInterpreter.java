package dansplugins.dansapi.commands;

import org.bukkit.command.CommandSender;

public interface ICommandInterpreter {
    boolean interpretCommand(CommandSender sender, String label, String[] args);
}
