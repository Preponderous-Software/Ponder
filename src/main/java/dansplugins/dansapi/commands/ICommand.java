package dansplugins.dansapi.commands;

import org.bukkit.command.CommandSender;

public interface ICommand {
    boolean execute(CommandSender sender);
    boolean execute(CommandSender sender, String[] args);
}
