package dansplugins.ponder.implementation.commands;

import dansplugins.ponder.implementation.PonderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ConfigCommand extends Command {

    private PonderAPI ponderAPI;

    public ConfigCommand(PonderAPI dansAPI) {
        this.ponderAPI = dansAPI;
    }

    @Override
    public boolean execute(CommandSender sender) {
        // unused
        return false;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Sub-commands: show, set");
            return false;
        }

        if (args[0].equalsIgnoreCase("show")) {
            ponderAPI.getConfigService().sendConfigList(sender);
            return true;
        }
        else if (args[0].equalsIgnoreCase("set")) {
            if (args.length < 3) {
                sender.sendMessage(ChatColor.RED + "Usage: /c config set (option) (value)");
                return false;
            }
            String option = args[1];

            String value = args[2];

            ponderAPI.getConfigService().setConfigOption(option, value, sender);
            return true;
        }
        else {
            sender.sendMessage(ChatColor.RED + "Sub-commands: show, set");
            return false;
        }
    }

}
