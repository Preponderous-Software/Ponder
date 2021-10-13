package preponderous.ponder.toolbox.tools.specification;

import preponderous.ponder.services.specification.IExpandedStorageService;

public interface IScheduler {
    void scheduleAutosave(IExpandedStorageService storageService);
}
