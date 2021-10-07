package dansplugins.dansapi.implementation.services;

import dansplugins.dansapi.implementation.toolbox.tools.Scheduler;
import dansplugins.dansapi.specification.services.IStorageService;
import dansplugins.dansapi.specification.toolbox.tools.IScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageService implements IStorageService {

    private static StorageService instance;

    private StorageService() {

    }

    public static StorageService getInstance() {
        if (instance == null) {
            instance = new StorageService();
        }
        return instance;
    }

    @Override
    public void save() {
        // TODO: implement
    }

    @Override
    public void load() {
        // TODO: implement
    }

    @Override
    public void writeOutFiles(List<Map<String, String>> saveData, String fileName) {
        // TODO: implement
    }

    @Override
    public ArrayList<HashMap<String, String>> loadDataFromFilename(String filename) {
        // TODO: implement
        return null;
    }
}
