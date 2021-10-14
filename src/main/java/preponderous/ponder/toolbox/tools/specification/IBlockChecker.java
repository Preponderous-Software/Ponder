package preponderous.ponder.toolbox.tools.specification;

import org.bukkit.Material;
import org.bukkit.block.Block;

public interface IBlockChecker {
    boolean isChest(Block block);
    boolean isDoor(Block block);
    boolean isTrapdoor(Block block);
    boolean isFurnace(Block block);
    boolean isAnvil(Block block);
    boolean isGate(Block block);
    boolean isBarrel(Block block);
    Material compatMaterial(String materialName);
}
