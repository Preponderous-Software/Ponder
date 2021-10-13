package preponderous.ponder.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.services.specification.IConfigService;

import java.util.HashMap;

public class ConfigService implements IConfigService {

    private PonderAPI ponderAPI;

    private HashMap<String, Object> optionsToValues = new HashMap<>();

    private boolean altered = false;

    public ConfigService(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    @Override
    public void initialize(HashMap<String, Object> optionsToValues) {
        this.optionsToValues = optionsToValues;
    }

    @Override
    public boolean addConfigOption(String option, Object value) {
        if (optionsToValues.containsKey(option)) {
            return false;
        }
        optionsToValues.put(option, value);
        return true;
    }

    @Override
    public boolean removeConfigOption(String option) {
        return optionsToValues.remove(option) != null;
    }

    @Override
    public void saveMissingConfigDefaultsIfNotPresent() {
        for (String key : optionsToValues.keySet()) {
            if (!getConfig().isSet(key)) {
                getConfig().set(key, optionsToValues.get(key));
            }
        }
        getConfig().options().copyDefaults(true);
        ponderAPI.getPlugin().saveConfig();
    }

    @Override
    public void setConfigOption(String option, String value, CommandSender sender) {
        if (getConfig().isSet(option)) {
            getConfig().set(option, value);
            ponderAPI.getPlugin().saveConfig();
            altered = true;
        } else {
            sender.sendMessage(ChatColor.RED + "That config option wasn't found.");
        }
    }

    @Override
    public void sendConfigList(CommandSender sender) {
        sender.sendMessage(ChatColor.AQUA + "=== Config List ===");
        String toSend = "";
        for (String key : optionsToValues.keySet()) {
            toSend += key + ": " + optionsToValues.get(key) + ", \n";
        }
        sender.sendMessage(ChatColor.AQUA + toSend);
    }

    @Override
    public boolean hasBeenAltered() {
        return altered;
    }

    @Override
    public FileConfiguration getConfig() {
        return ponderAPI.getPlugin().getConfig();
    }

    @Override
    public int getInt(String option) {
        return getConfig().getInt(option);
    }

    @Override
    public boolean getBoolean(String option) {
        return getConfig().getBoolean(option);
    }

    @Override
    public double getDouble(String option) {
        return getConfig().getDouble(option);
    }

    @Override
    public String getString(String option) {
        return getConfig().getString(option);
    }

}