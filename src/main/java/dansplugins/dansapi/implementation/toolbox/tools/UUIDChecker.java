package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.specification.toolbox.tools.IPermissionChecker;
import dansplugins.dansapi.specification.toolbox.tools.IUUIDChecker;

import java.util.UUID;

public class UUIDChecker implements IUUIDChecker {

    private static UUIDChecker instance;

    private UUIDChecker() {

    }

    public static UUIDChecker getInstance() {
        if (instance == null) {
            instance = new UUIDChecker();
        }
        return instance;
    }

    @Override
    public String findPlayerNameBasedOnUUID(UUID playerUUID) {
        // TODO: implement
        return null;
    }

    @Override
    public UUID findUUIDBasedOnPlayerName(String playerName) {
        // TODO: implement
        return null;
    }
}
