/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.bukkit.services;

import preponderous.ponder.minecraft.bukkit.PonderMC;
import preponderous.ponder.misc.Pair;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

/**
 * @author Daniel McCoy Stephenson
 */
public class LocaleService {
    private final PonderMC ponder;

    private List<String> supportedLanguageIDs;

    private final List<String> keys;
    private final Map<String, String> strings;

    private String languageFolderPath;
    private String localizationFileName;
    private String localizationFilePath;

    private String currentLanguageID;

    public LocaleService(PonderMC ponder) {
        this.ponder = ponder;
        keys = new ArrayList<>();
        strings = new HashMap<>();
    }

    public void initialize(List<String> supportedLanguageIDs, String pluginFolderPath, String pluginName, String defaultLanguageID) {
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

    public String getText(String key) {
        return getValueAssociatedWithTranslationKey(key);
    }

    public void loadTranslationKeysAndStrings() {
        if (isFilePresent(localizationFilePath)) {
            loadFromPluginFolder();
            ponder.log("Loaded from plugin folder!");
        }
        else {
            loadFromResource();
            ponder.log("Loaded from resource!");
        }
        ponder.log(String.format(getText("KeysLoaded") + "%n", keys.size()));
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
            loadFromFile(file);
            updateCurrentLocalLanguageFile();
            saveToPluginFolder();

        } catch (Exception e) {
            ponder.log("Something went wrong loading from the plugin folder.");
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
            ponder.log("Something went wrong loading from file!");
            e.printStackTrace();
        }
    }

    /**
     * Method to updated the current language file.
     *
     */
    public void updateCurrentLocalLanguageFile() {
        ponder.log("LocaleManager is updating supported local language files.");
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

    public InputStream getResourceAsInputStream(String fileName) {
        return ponder.getPlugin().getResource(fileName);
    }

    /**
     * Method to load from a resource associated with the current language ID.
     *
     */
    public void loadFromResource() {
        try {
            InputStream inputStream = getResourceAsInputStream(localizationFileName);
            loadMissingKeysFromInputStream(inputStream);
            saveToPluginFolder();
        } catch (Exception e) {
            ponder.log("Error loading from resource!");
            e.printStackTrace();
        }
    }

    public void loadMissingKeysFromInputStream(InputStream inputStream) {
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(reader);
        br.lines().forEach(line -> {
            Pair<String, String> pair = getPairFromLine(line);
            if (pairFoundAndKeyNotAlreadyLoaded(pair)) {
                strings.put(pair.getLeft(), pair.getRight());
                keys.add(pair.getLeft());
            }
        });
    }

    private boolean pairFoundAndKeyNotAlreadyLoaded(Pair<String, String> pair) {
        return pair != null && !strings.containsKey(pair.getLeft());
    }

    public Pair<String, String> getPairFromLine(String line) {
        String key;
        String value;

        int tabIndex = getIndexOfFirstTab(line);

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
     * Method to save to the plugin folder.
     *
     */
    public void saveToPluginFolder() {
        sortKeys();

        try {
            createDirectory();
            File file = createFile();

            try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
                for (String key : keys) {
                    output.write(key + "\t" + strings.get(key) + "\n");
                }
            } catch (Exception ex) {
                ponder.log("Failed to write to file.");
            }
        } catch (Exception e) {
            ponder.log("There was a problem saving the strings.");
            e.printStackTrace();
        }
    }

    private File createFile() throws Exception {
        File file = new File(localizationFilePath);
        if (!file.exists() && !file.createNewFile()) {
            ponder.log("Failed to create file.");
            throw new Exception();
        }
        return file;
    }

    private void createDirectory() throws Exception {
        File folder = new File(languageFolderPath);
        if (!folder.exists() && !folder.mkdir()) {
            ponder.log("Failed to create directory.");
            throw new Exception();
        }
    }

    public void sortKeys() {
        Collections.sort(keys);
    }

    private int getIndexOfFirstTab(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\t') {
                return i;
            }
        }
        return -1;
    }

    private String getValueAssociatedWithTranslationKey(String key) {
        if (!keys.contains(key)) {
            return String.format("[key '%s' not found]", key);
        }
        return strings.get(key);
    }
}
