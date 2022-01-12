/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.abs;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.minecraft.spigot.PonderMC;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class PonderPlugin extends JavaPlugin {
    private final PonderMC ponder = new PonderMC(this);

    /**
     * This can be used to get the managed instance of Ponder.
     * @return The managed instance of Ponder.
     */
    public PonderMC getPonder() {
        return ponder;
    }
}