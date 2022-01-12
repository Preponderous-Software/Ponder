/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.spigot.services;

import preponderous.ponder.minecraft.spigot.PonderMC;
import preponderous.ponder.misc.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Daniel McCoy Stephenson
 */
public class LocaleService {

    private final PonderMC ponder;

    private ArrayList<String> supportedLanguageIDs;

    private final ArrayList<String> keys;
    private final HashMap<String, String> strings;

    private String languageFolderPath;
    private String localizationFileName;
    private String localizationFilePath;

    private String currentLanguageID;

    public LocaleService(PonderMC ponder) {
        this.ponder = ponder;
        keys = new ArrayList<>();
        strings = new HashMap<>();
    }

    public void initialize(ArrayList<String> supportedLanguageIDs, String pluginFolderPath, String pluginName, String defaultLanguageID) {
        this.supportedLanguageIDs = supportedLanguageIDs;
        languageFolderPath = pluginFolderPath + pluginName + "/";
        localizationFileName = defaultLanguageID + ".tsv";
        localizationFilePath = languageFolderPath + localizationFileName;
        currentLanguageID = defaultLanguageID;
    }

    public String getCurrentLanguageID() {
        return currentLanguageID;
    }

    public void setCurrentLanguageID(String ID) {
        currentLanguageID = ID;
    }

    /**
     * Method to get a value associated with a translation key.
     *
     */
    public String getText(String key) {
        if (!keys.contains(key)) return String.format("[key '%s' not found]", key);
        return strings.get(key);
    }

    public void loadTranslationKeysAndStrings() {
        if (isFilePresent(localizationFilePath)) {
            loadFromPluginFolder();
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Loaded from plugin folder!"); }
        }
        else {
            loadFromResource();
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Loaded from resource!"); }
        }
        if (ponder.isDebugEnabled()) { System.out.printf((getText("KeysLoaded")) + "%n", keys.size()); }
    }

    public void reloadTranslationKeysAndStrings() {
        keys.clear();
        strings.clear();
        loadTranslationKeysAndStrings();
    }

    public boolean isLanguageIDSupported(String ID) {
        return supportedLanguageIDs.contains(ID);
    }

    public String getSupportedLanguageIDsSeparatedByCommas() {
        StringBuilder IDs = new StringBuilder();
        for (int i = 0; i < supportedLanguageIDs.size(); i++) {
            IDs.append(supportedLanguageIDs.get(i));
            if (i != supportedLanguageIDs.size() - 1) {
                IDs.append(", ");
            }
        }
        return IDs.toString();
    }

    /**
     * Method to check if a file is present.
     *
     */
    public boolean isFilePresent(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * Method to load from the plugin folder.
     *
     */
    public void loadFromPluginFolder() {
        File file = new File(localizationFilePath);
        try {

            // load from local language file
            loadFromFile(file);

            // update local language files
            updateCurrentLocalLanguageFile();

            // save
            saveToPluginFolder();

        } catch (Exception e) {
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Something went wrong loading from the plugin folder."); }
            e.printStackTrace();
        }
    }

    /**
     * Helper method to load from a file.
     *
     */
    public void loadFromFile(File file) {
        try {
            List<String> lines = Files.readAllLines(file.toPath());

            for (String line : lines) {
                Pair<String, String> pair = getPairFromLine(line);
                if (pair != null && !strings.containsKey(pair.getLeft())) {
                    strings.put(pair.getLeft(), pair.getRight());
                    keys.add(pair.getLeft());
                }
            }

        } catch (Exception e) {
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Something went wrong loading from file!"); }
            e.printStackTrace();
        }
    }

    /**
     * Method to updated the current language file.
     *
     */
    public void updateCurrentLocalLanguageFile() {
        if (ponder.isDebugEnabled()) { System.out.println("DEBUG: LocaleManager is updating supported local language files."); }
        if (isLanguageIDSupported(currentLanguageID)) {
            InputStream inputStream;
            inputStream = getResourceAsInputStream(currentLanguageID + ".tsv");
            loadMissingKeysFromInputStream(inputStream);
        }
        else {
            InputStream inputStream;
            inputStream = getResourceAsInputStream("en-us.tsv");
            loadMissingKeysFromInputStream(inputStream);
        }
    }

    /**
     * Method to get a resource as an input stream.
     *
     */
    public InputStream getResourceAsInputStream(String fileName) {
        return ponder.getPlugin().getResource(fileName);
    }

    /**
     * Method to load from a resource associated with the current language ID.
     *
     */
    public void loadFromResource() {
        try {
            // get resource as input stream
            InputStream inputStream = getResourceAsInputStream(localizationFileName);
            loadMissingKeysFromInputStream(inputStream);
            saveToPluginFolder();
        } catch (Exception e) {
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Error loading from resource!"); }
            e.printStackTrace();
        }
    }

    /**
     * Method to load the missing keys from the input stream.
     *
     */
    public void loadMissingKeysFromInputStream(InputStream inputStream) {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
        br.lines().forEach(line -> {
            Pair<String, String> pair = getPairFromLine(line);
            if (pair != null && !strings.containsKey(pair.getLeft())) { // if pair found and if key not already loaded
                strings.put(pair.getLeft(), pair.getRight());
                keys.add(pair.getLeft());
//                System.out.println(String.format("DEBUG: Loaded missing key %s from resources!", pair.getLeft()));
            }
        });
    }

    /**
     * Method to get a pair from a line.
     *
     */
    public Pair<String, String> getPairFromLine(String line) {
        String key;
        String value;

        int tabIndex = getIndexOfTab(line);

        if (tabIndex != -1) {
            key = line.substring(0, tabIndex);
            value = line.substring(tabIndex + 1);
            return new Pair<>(key, value);
        }
        else {
            return null;
        }
    }

    /**
     * Method to get the index of the first tab character.
     *
     */
    public int getIndexOfTab(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\t') {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to save to the plugin folder.
     *
     */
    public void saveToPluginFolder() {

        sortKeys();

        try {
            File folder = new File(languageFolderPath);
            if (!folder.exists()) {
                if (!folder.mkdir()) {
                    if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Failed to create directory."); }
                    return;
                }
            }
            File file = new File(localizationFilePath);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Failed to create file."); }
                    return;
                }
            }
            try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8))) {
                for (String key : keys) {
                    output.write(key + "\t" + strings.get(key) + "\n");
                }
            } catch (Exception ex) {
                if (ponder.isDebugEnabled()) { System.out.println("DEBUG: Failed to write to file."); }
            }
        } catch (Exception e) {
            if (ponder.isDebugEnabled()) { System.out.println("DEBUG: There was a problem saving the strings."); }
            e.printStackTrace();
        }
    }

    /**
     * Method to sort the keys.
     *
     */
    public void sortKeys() {
        Collections.sort(keys);
    }
}
