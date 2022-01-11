/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.spigot.misc;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.minecraft.spigot.PonderMC;

/**
 * @author Daniel McCoy Stephenson
 * @deprecated
 */
public class PonderAPI_Integrator {

    private PonderMC ponder = null;

    /**
     * Constructor to initialize the API.
     *
     */
    public PonderAPI_Integrator(JavaPlugin plugin) {
        ponder = new PonderMC(plugin);
    }

    /**
     * Method to get the instance of the Ponder API that is managed by this class.
     *
     * @return The instance of the Ponder API that is managed by this class.
     */
    public PonderMC getAPI() {
        return ponder;
    }

}
