package preponderous.ponder.toolbox.tools;

import org.bukkit.ChatColor;
import preponderous.ponder.toolbox.tools.specification.IColorChecker;

public class ColorChecker implements IColorChecker {

    @Override
    public ChatColor getColorByName(String color) {
        for (ChatColor value : ChatColor.values()) {
            if (value.name().equalsIgnoreCase(color)) {
                return value;
            }
        }
        return ChatColor.WHITE;
    }

}
