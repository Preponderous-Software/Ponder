package preponderous.ponder.commands.specification;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public interface ICommand {
    boolean execute(CommandSender sender);
    boolean execute(CommandSender sender, String[] args);
    boolean sendMessageIfNoArguments(String message, String[] args, CommandSender sender, ChatColor color);
}
