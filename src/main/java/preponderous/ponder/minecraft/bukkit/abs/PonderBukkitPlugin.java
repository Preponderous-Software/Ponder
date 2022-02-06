/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.bukkit.abs;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.Ponder;
import preponderous.ponder.minecraft.abs.PonderPlugin;
import preponderous.ponder.minecraft.bukkit.PonderMC;

/**
 * @author Daniel McCoy Stephenson
 */
public abstract class PonderBukkitPlugin extends JavaPlugin implements PonderPlugin {
    private final PonderMC ponder = new PonderMC(this);

    public PonderBukkitPlugin() {

    }

    @Override
    public PonderMC getPonder() {
        return this.ponder;
    }
}