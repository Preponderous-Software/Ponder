package preponderous.ponder.misc;

import preponderous.ponder.services.StorageService;

public abstract class AbstractExpandedStorageService extends StorageService {
    public abstract boolean save();
    public abstract boolean load();
}
