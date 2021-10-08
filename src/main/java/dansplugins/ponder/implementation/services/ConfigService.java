package dansplugins.ponder.implementation.services;

import dansplugins.ponder.implementation.PonderAPI;
import dansplugins.ponder.specification.services.IConfigService;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigService implements IConfigService {

    private PonderAPI ponderAPI;

    public ConfigService(PonderAPI dansAPI) {
        this.ponderAPI = dansAPI;
    }

    @Override
    public void saveMissingConfigDefaultsIfNotPresent() {
        // TODO: implement
    }

    @Override
    public void setConfigOption(String option, String value, CommandSender sender) {
        // TODO: implement
    }

    @Override
    public void sendConfigList(CommandSender sender) {
        // TODO: implement
    }

    @Override
    public boolean hasBeenAltered() {
        // TODO: implement
        return false;
    }

    @Override
    public FileConfiguration getConfig() {
        // TODO: implement
        return null;
    }

    @Override
    public int getInt(String option) {
        // TODO: implement
        return 0;
    }

    @Override
    public boolean getBoolean(String option) {
        // TODO: implement
        return false;
    }

    @Override
    public double getDouble(String option) {
        // TODO: implement
        return 0;
    }

    @Override
    public String getString(String option) {
        // TODO: implement
        return null;
    }
}
