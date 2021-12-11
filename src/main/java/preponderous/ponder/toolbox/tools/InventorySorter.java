package preponderous.ponder.toolbox.tools;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import preponderous.ponder.Ponder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventorySorter {
    private Ponder ponder;

    public InventorySorter(Ponder ponder) {
        this.ponder = ponder;
    }

    /**
     * Method to sort an inventory.
     *
     * @param inventory Inventory to sort.
     */
    public void sortInventory(Inventory inventory) {
        ItemStack[] contentsArray = inventory.getContents();
        List<ItemStack> contentsArrayList = new ArrayList<>(Arrays.asList(contentsArray));
        // TODO: sort the contents of the inventory
    }
}