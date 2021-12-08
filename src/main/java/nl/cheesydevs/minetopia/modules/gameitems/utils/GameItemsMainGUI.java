package nl.cheesydevs.minetopia.modules.gameitems.utils;

import nl.cheesydevs.minetopia.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GameItemsMainGUI {

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 3*9, Chat.color(""));
        ItemStack itemStack = new ItemStack(Material.APPLE);
        inventory.setItem(9+4, itemStack);
        return inventory;
    }

}
