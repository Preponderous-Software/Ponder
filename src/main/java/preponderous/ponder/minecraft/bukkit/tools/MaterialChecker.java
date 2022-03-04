package preponderous.ponder.minecraft.bukkit.tools;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

/**
 * @author Daniel McCoy Stephenson
 * @author VoChiDanh
 */
public class MaterialChecker {

    public boolean isCoal(@NotNull Material material) {
        return material.name().contains("COAL");
    }

    public boolean isIron(@NotNull Material material) {
        return material.name().contains("IRON");
    }

    public boolean isGold(@NotNull Material material) {
        return material.name().contains("GOLD");
    }

    public boolean isRedstone(@NotNull Material material) {
        return material.name().contains("REDSTONE");
    }

    public boolean isLapis(@NotNull Material material) {
        return material.name().contains("LAPIS");
    }

    public boolean isDiamond(@NotNull Material material) {
        return material.name().contains("DIAMOND");
    }

    public boolean isEmerald(@NotNull Material material) {
        return material.name().contains("EMERALD");
    }

    public boolean isLog(@NotNull Material material) {
        return material.name().contains("LOG");
    }

    public boolean isStone(@NotNull Material material) {
        return material.name().contains("STONE");
    }

    public boolean isAxe(@NotNull Material material) {
        return material.name().contains("AXE");
    }

    public boolean isPickaxe(@NotNull Material material) {
        return material.name().contains("PICKAXE");
    }

    public boolean isSword(@NotNull Material material) {
        return material.name().contains("SWORD");
    }

    public boolean isShovel(@NotNull Material material) {
        return material.name().contains("SHOVEL");
    }

    public boolean isHoe(@NotNull Material material) {
        return material.name().contains("HOE");
    }

}
