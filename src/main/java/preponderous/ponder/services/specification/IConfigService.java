package preponderous.ponder.services.specification;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public interface IConfigService {
    void initialize(HashMap<String, Object> optionsToValues);
    boolean addConfigOption(String option, Object value);
    boolean removeConfigOption(String option);
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
