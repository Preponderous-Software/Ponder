package preponderous.ponder.services;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.services.specification.IConfigService;

import java.util.HashMap;

public class ConfigService implements IConfigService {

    private PonderAPI ponderAPI;

    private HashMap<String, Object> optionsToValues;

    private boolean altered = false;

    public ConfigService(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    /**
     * Method to initialize the config options and their associated values.
     *
     * @param optionsToValues to initialize with.
     */
    @Override
    public void initialize(HashMap<String, Object> optionsToValues) {
        this.optionsToValues = optionsToValues;
    }

    /**
     * Method to add a config option if it doesn't already exist. This should only be used if the class has been initialized.
     *
     * @param option to alter.
     * @param value to set the option to.
     * @return {@link boolean} signifying whether or not the config option was added.
     */
    @Override
    public boolean addConfigOption(String option, Object value) {
        if (optionsToValues == null) {
            return false;
        }
        if (optionsToValues.containsKey(option)) {
            return false;
        }
        optionsToValues.put(option, value);
        return true;
    }

    /**
     * Method to remove a config option if it doesn't already exist. This should only be used if the class has been initialized.
     *
     * @param option to remove.
     * @return {@link boolean} signifying whether or not the config option was removed.
     */
    @Override
    public boolean removeConfigOption(String option) {
        return optionsToValues.remove(option) != null;
    }

    /**
     * Method to save the config defaults if they aren't present. This should only be used if the class has been initialized.
     *
     */
    @Override
    public void saveMissingConfigDefaultsIfNotPresent() {
        if (optionsToValues == null) {
            return;
        }
        for (String key : optionsToValues.keySet()) {
            if (!getConfig().isSet(key)) {
                getConfig().set(key, optionsToValues.get(key));
            }
        }
        getConfig().options().copyDefaults(true);
        ponderAPI.getPlugin().saveConfig();
    }

    /**
     * Method to set a config option.
     *
     * @param option to alter.
     * @param value to set the option to.
     * @param sender to send an error message to.
     */
    @Override
    public void setConfigOption(String option, Object value, CommandSender sender) {
        if (getConfig().isSet(option)) {
            getConfig().set(option, value);
            ponderAPI.getPlugin().saveConfig();
            altered = true;
        } else {
            sender.sendMessage(ChatColor.RED + "That config option wasn't found.");
        }
    }

    /**
     * Method to send a list of config options and their associated values to a command sender. This should only be used if the class has been initialized.
     *
     * @param sender to send an error message to.
     */
    @Override
    public void sendConfigList(CommandSender sender) {
        if (optionsToValues == null) {
            return;
        }
        sender.sendMessage(ChatColor.AQUA + "=== Config List ===");
        String toSend = "";
        for (String key : optionsToValues.keySet()) {
            toSend += key + ": " + optionsToValues.get(key) + ", \n";
        }
        sender.sendMessage(ChatColor.AQUA + toSend);
    }

    /**
     * Method to find out whether or not the config options have been locally altered.
     *
     * @return {@link boolean} signifying whether or not the config options have been locally altered.
     */
    @Override
    public boolean hasBeenAltered() {
        return altered;
    }

    /**
     * Method to get the file configuration.
     *
     * @return {@link FileConfiguration}
     */
    @Override
    public FileConfiguration getConfig() {
        return ponderAPI.getPlugin().getConfig();
    }

    /**
     * Method to get the value of a config option which is an integer.
     *
     * @return {@link int}
     */
    @Override
    public int getInt(String option) {
        return getConfig().getInt(option);
    }

    /**
     * Method to get the value of a config option which is a boolean.
     *
     * @return {@link boolean}
     */
    @Override
    public boolean getBoolean(String option) {
        return getConfig().getBoolean(option);
    }

    /**
     * Method to get the value of a config option which is a double.
     *
     * @return {@link double}
     */
    @Override
    public double getDouble(String option) {
        return getConfig().getDouble(option);
    }

    /**
     * Method to get the value of a config option which is a string.
     *
     * @return {@link String}
     */
    @Override
    public String getString(String option) {
        return getConfig().getString(option);
    }

}