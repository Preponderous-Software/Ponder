/*
  Copyright (c) 2022 Preponderous Software
  MIT License
 */
package preponderous.ponder.minecraft.bukkit.tools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getLogger;

/**
 * @author Daniel McCoy Stephenson
 * @author Caibinus
 */
public class BlockChecker {

    /**
     * Method to check whether or not the block is a chest.
     *
     * @return A {@link boolean} signifying whether or not the block is a chest.
     */
    public boolean isChest(@NotNull Block block) {
        return block.getType().name().contains("CHEST") && block.getState() instanceof Chest;
    }

    /**
     * Method to check whether or not the block is a door.
     *
     * @return A {@link boolean} signifying whether or not the block is a door.
     */
    public boolean isDoor(@NotNull Block block) {
        return block.getType().name().contains("DOOR");
    }

    /**
     * Method to check whether or not the block is a trapdoor.
     *
     * @return A {@link boolean} signifying whether or not the block is a trapdoor.
     */
    public boolean isTrapdoor(@NotNull Block block) {
        return block.getType().name().contains("TRAPDOOR");
    }

    /**
     * Method to check whether or not the block is a furnace.
     *
     * @return A {@link boolean} signifying whether or not the block is a furnace.
     */
    public boolean isFurnace(@NotNull Block block) {
        return block.getType().name().contains("FURNACE");
    }

    /**
     * Method to check whether or not the block is an anvil.
     *
     * @return A {@link boolean} signifying whether or not the block is an anvil.
     */
    public boolean isAnvil(@NotNull Block block) {
        return block.getType().name().contains("ANVIL");
    }

    /**
     * Method to check whether or not the block is a gate.
     *
     * @return A {@link boolean} signifying whether or not the block is a gate.
     */
    public boolean isGate(@NotNull Block block) {
        return block.getType().name().contains("GATE");
    }

    /**
     * Method to check whether or not the block is an anvil.
     *
     * @return A {@link boolean} signifying whether or not the block is an anvil.
     */
    public boolean isBarrel(@NotNull Block block) {
        return block.getType().name().contains("BARREL");
    }

    /**
     * Method to get a Material by name.
     *
     * @return A {@link Material} matching the name.
     */
    public Material compatMaterial(String materialName) {
        Material mat = Material.getMaterial(materialName);
        if (mat == null) {
            // Find compatible substitute.
            switch(materialName) {
                case "CRIMSON_FENCE_GATE":
                case "WARPED_FENCE_GATE":
                    return Material.OAK_FENCE_GATE;
                case "CRIMSON_DOOR":
                case "WARPED_DOOR":
                    return Material.OAK_DOOR;
                case "CRIMSON_TRAPDOOR":
                case "WARPED_TRAPDOOR":
                    return Material.OAK_TRAPDOOR;
                default:
                    getLogger().info("ERROR: Could not locate a compatible material matching '" + materialName + "'.");
                    return null;
            }
        }
        else {
            return mat;
        }
    }

}
