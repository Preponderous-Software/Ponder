package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.specification.toolbox.tools.IScheduler;
import dansplugins.dansapi.specification.toolbox.tools.IUUIDChecker;

public class Scheduler implements IScheduler {

    private static Scheduler instance;

    private Scheduler() {

    }

    public static Scheduler getInstance() {
        if (instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    @Override
    public void scheduleAutosave() {
        // TODO: implement
    }
}
