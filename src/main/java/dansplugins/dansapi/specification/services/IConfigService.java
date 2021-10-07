package dansplugins.dansapi.specification.services;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public interface IConfigService {
    void saveMissingConfigDefaultsIfNotPresent();
    void setConfigOption(String option, String value, CommandSender sender);
    void sendConfigList(CommandSender sender);
    boolean hasBeenAltered();
    FileConfiguration getConfig();
    int getInt(String option);
    boolean getBoolean(String option);
    double getDouble(String option);
    String getString(String option);
}
