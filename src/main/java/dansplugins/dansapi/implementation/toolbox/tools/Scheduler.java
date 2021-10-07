package dansplugins.dansapi.implementation.toolbox.tools;

import dansplugins.dansapi.implementation.DansAPI;
import dansplugins.dansapi.specification.toolbox.tools.IScheduler;
import org.bukkit.Bukkit;

public class Scheduler implements IScheduler {

    private DansAPI dansAPI;

    public Scheduler(DansAPI dansAPI) {
        this.dansAPI = dansAPI;
    }

    @Override
    public void scheduleAutosave() {
        int delay = 60 * 60; // 1 hour
        int secondsUntilRepeat = 60 * 60; // 1 hour
        Bukkit.getScheduler().scheduleSyncRepeatingTask(dansAPI.getPlugin(), new Runnable() {
            @Override
            public void run() {
                dansAPI.getStorageService().save();
            }
        }, delay * 20, secondsUntilRepeat * 20);
    }

}
