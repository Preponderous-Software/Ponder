package preponderous.ponder.toolbox.tools.specification;

import org.bukkit.entity.Player;

public interface IMessenger {
    void sendAllPlayersOnServerMessage(String message);
    int sendMessageToPlayersWithinDistance(Player player, String message, int distance);
}
