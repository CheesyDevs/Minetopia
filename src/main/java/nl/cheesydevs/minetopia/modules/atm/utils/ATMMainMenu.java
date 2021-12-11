package nl.cheesydevs.minetopia.modules.atm.utils;

import nl.cheesydevs.minetopia.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("SpellCheckingInspection")
public class ATMMainMenu {

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 3 * 9, LanguageFile.get("SelectRekening"));
        inventory.setItem(9+2, getItem(Material.REDSTONE_BLOCK, LanguageFile.get("SpaarRekening")));
        inventory.setItem(9+4, getItem(Material.GOLD_BLOCK, LanguageFile.get("PriveRekenking")));
        inventory.setItem(9+6, getItem(Material.DIAMOND_BLOCK, LanguageFile.get("BedrijfsRekening")));
        return inventory;
    }

    private static ItemStack getItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        if(itemMeta == null) return null;
        itemMeta.setDisplayName(Chat.color(displayName));
        item.setItemMeta(itemMeta);
        return item;
    }
}
