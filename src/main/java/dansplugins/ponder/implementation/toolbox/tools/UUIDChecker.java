package dansplugins.ponder.implementation.toolbox.tools;

import dansplugins.ponder.specification.toolbox.tools.IUUIDChecker;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

import static org.bukkit.Bukkit.getOfflinePlayers;
import static org.bukkit.Bukkit.getOnlinePlayers;

public class UUIDChecker implements IUUIDChecker {

    @Override
    public String findPlayerNameBasedOnUUID(UUID playerUUID) {
        // check online players
        for (Player player : getOnlinePlayers()) {
            if (player.getUniqueId().equals(playerUUID)) {
                return player.getName();
            }
        }

        // check offline players
        for (OfflinePlayer player : getOfflinePlayers()) {
            if (player.getUniqueId().equals(playerUUID)) {
                return player.getName();
            }
        }
        return "";
    }

    @Override
    public UUID findUUIDBasedOnPlayerName(String playerName) {
        // check online players
        for (Player player : getOnlinePlayers()) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return player.getUniqueId();
            }
        }

        // check offline players
        for (OfflinePlayer player : getOfflinePlayers()) {
            try {
                if (player.getName() == null) {
                    return null;
                }
                if (player.getName().equalsIgnoreCase(playerName)) {
                    return player.getUniqueId();
                }
            } catch (NullPointerException e) {
                // fail silently as this is might be common
            }
        }

        return null;
    }

}
