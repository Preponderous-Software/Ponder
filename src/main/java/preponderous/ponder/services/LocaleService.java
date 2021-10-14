package preponderous.ponder.services;

import preponderous.ponder.PonderAPI;
import preponderous.ponder.misc.Pair;
import preponderous.ponder.services.specification.ILocaleService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class LocaleService implements ILocaleService {

    private PonderAPI ponderAPI;

    private ArrayList<String> supportedLanguageIDs;

    private ArrayList<String> keys;
    private HashMap<String, String> strings;

    private String languageFolderPath;
    private String localizationFileName;
    private String localizationFilePath;

    private String currentLanguageID;

    public LocaleService(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
        keys = new ArrayList<>();
        strings = new HashMap<>();
    }

    @Override
    public void initialize(ArrayList<String> supportedLanguageIDs, String pluginFolderPath, String pluginName, String defaultLanguageID) {
        this.supportedLanguageIDs = supportedLanguageIDs;
        languageFolderPath = pluginFolderPath + pluginName + "/";
        localizationFileName = defaultLanguageID + ".tsv";
        localizationFilePath = languageFolderPath + localizationFileName;
        currentLanguageID = defaultLanguageID;
    }

    @Override
    public String getCurrentLanguageID() {
        return currentLanguageID;
    }

    @Override
    public void setCurrentLanguageID(String ID) {
        currentLanguageID = ID;
    }

    @Override
    public String getText(String key) {
        if (!keys.contains(key)) return String.format("[key '%s' not found]", key);
        return strings.get(key);
    }

    @Override
    public void loadStrings() {
        if (isFilePresent(localizationFilePath)) {
            loadFromPluginFolder();
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Loaded from plugin folder!"); }
        }
        else {
            loadFromResource();
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Loaded from resource!"); }
        }
        if (ponderAPI.isDebugEnabled()) { System.out.println(String.format(getText("KeysLoaded"), keys.size())); }
    }

    @Override
    public void reloadStrings() {
        keys.clear();
        strings.clear();
        loadStrings();
    }

    @Override
    public boolean isLanguageIDSupported(String ID) {
        return supportedLanguageIDs.contains(ID);
    }

    @Override
    public String getSupportedLanguageIDsSeparatedByCommas() {
        String IDs = "";
        for (int i = 0; i < supportedLanguageIDs.size(); i++) {
            IDs = IDs + supportedLanguageIDs.get(i);
            if (i != supportedLanguageIDs.size() - 1) {
                IDs = IDs + ", ";
            }
        }
        return IDs;
    }

    @Override
    public boolean isFilePresent(String path) {
        File file = new File(path);
        return file.exists();
    }

    @Override
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
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Something went wrong loading from the plugin folder."); }
            e.printStackTrace();
        }
    }

    @Override
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
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Something went wrong loading from file!"); }
            e.printStackTrace();
        }
    }

    @Override
    public void updateCurrentLocalLanguageFile() {
        if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: LocaleManager is updating supported local language files."); }
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

    @Override
    public InputStream getResourceAsInputStream(String fileName) {
        return ponderAPI.getPlugin().getResource(fileName);
    }

    @Override
    public void loadFromResource() {
        try {
            // get resource as input stream
            InputStream inputStream = getResourceAsInputStream(localizationFileName);
            loadMissingKeysFromInputStream(inputStream);
            saveToPluginFolder();
        } catch (Exception e) {
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Error loading from resource!"); }
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
    public Pair<String, String> getPairFromLine(String line) {
        String key = "";
        String value = "";

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

    private int getIndexOfTab(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '\t') {
                return i;
            }
        }
        return -1;
    }

    private void saveToPluginFolder() {

        sortKeys();

        try {
            File folder = new File(languageFolderPath);
            if (!folder.exists()) {
                if (!folder.mkdir()) {
                    if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Failed to create directory."); }
                    return;
                }
            }
            File file = new File(localizationFilePath);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Failed to create file."); }
                    return;
                }
            }
            try (BufferedWriter output = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), StandardCharsets.UTF_8))) {
                for (String key : keys) {
                    output.write(key + "\t" + strings.get(key) + "\n");
                }
            } catch (Exception ex) {
                if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: Failed to write to file."); }
            }
        } catch (Exception e) {
            if (ponderAPI.isDebugEnabled()) { System.out.println("DEBUG: There was a problem saving the strings."); }
            e.printStackTrace();
        }
    }

    private void sortKeys() {
        Collections.sort(keys);
    }
}
