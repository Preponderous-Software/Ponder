package preponderous.ponder.toolbox.tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import preponderous.ponder.toolbox.tools.specification.IMessenger;

import static org.bukkit.Bukkit.getServer;

public class Messenger implements IMessenger {

    /**
     * Method to message every online player.
     *
     */
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

    /**
     * Method to send a message to players within a certain number of blocks from a player.
     *
     */
    @Override
    public int sendMessageToPlayersWithinDistance(Player player, String message, int distance) {
        Location playerLocation = player.getLocation();

        int numPlayersWhoHeard = 0;

        // for every online player
        for (Player potentialPlayer : getServer().getOnlinePlayers()) {

            // if not in world
            if (potentialPlayer.getLocation().getWorld().getName() != playerLocation.getWorld().getName()) {
                return -1;
            }

            // if not within the specified distance
            if (!(potentialPlayer.getLocation().distance(playerLocation) < distance)) {
                return -1;
            }

            numPlayersWhoHeard++;
            potentialPlayer.sendMessage(message);
        }
        return numPlayersWhoHeard;
    }

}
