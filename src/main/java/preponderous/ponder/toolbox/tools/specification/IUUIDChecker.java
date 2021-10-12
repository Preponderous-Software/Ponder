package preponderous.ponder.toolbox.tools.specification;

import java.util.UUID;

public interface IUUIDChecker {
    String findPlayerNameBasedOnUUID(UUID playerUUID);

    UUID findUUIDBasedOnPlayerName(String playerName);
}
