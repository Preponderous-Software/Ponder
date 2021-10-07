package dansplugins.dansapi.implementation.services;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.services.IConfigService;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigService implements IConfigService {

    private DansAPI dansAPI;

    public ConfigService(DansAPI dansAPI) {
        this.dansAPI = dansAPI;
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
