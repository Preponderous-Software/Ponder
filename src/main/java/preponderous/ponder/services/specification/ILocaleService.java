package preponderous.ponder.services.specification;

import preponderous.ponder.misc.Pair;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public interface ILocaleService {
    void initialize(ArrayList<String> supportedLanguageIDs, String pluginFolderPath, String pluginName, String defaultLanguageID);
    String getText(String key);
    void loadStrings();
    void reloadStrings();
    boolean isLanguageIDSupported(String ID);
    String getSupportedLanguageIDsSeparatedByCommas();
    boolean isFilePresent(String path);
    void loadFromPluginFolder();
    void loadFromFile(File file);
    void updateCurrentLocalLanguageFile();
    InputStream getResourceAsInputStream(String fileName);
    void loadFromResource();
    void loadMissingKeysFromInputStream(InputStream inputStream);
    Pair<String, String> getPairFromLine(String line);
}
