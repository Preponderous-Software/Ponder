package preponderous.ponder.misc;

import preponderous.ponder.services.StorageService;

/**
 * @author Daniel Stephenson
 */
public abstract class AbstractExpandedStorageService extends StorageService {
    public abstract boolean save();
    public abstract boolean load();
}
