package preponderous.ponder.toolbox.tools.specification;

import preponderous.ponder.misc.AbstractExpandedStorageService;

public interface IScheduler {
    void scheduleAutosave(AbstractExpandedStorageService storageService);
}
