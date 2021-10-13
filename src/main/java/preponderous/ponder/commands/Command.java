package preponderous.ponder.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import preponderous.ponder.commands.specification.ICommand;

public abstract class Command implements ICommand {

    public abstract boolean execute(CommandSender sender);

    public abstract boolean execute(CommandSender sender, String[] args);

    public boolean sendMessageIfNoArguments(String message, String[] args, CommandSender sender, ChatColor color) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + message);
            return true;
        }
        return false;
    }

}
