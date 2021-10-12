package preponderous.ponder.toolbox.tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import preponderous.ponder.toolbox.tools.specification.IMessenger;

public class Messenger implements IMessenger {

    @Override
    public void sendAllPlayersOnServerMessage(String message) {
        try {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(message);
            }
        }
        catch(Exception ignored) {

        }
    }

}
