package nl.cheesydevs.minetopia.utils.interfaces;

import nl.cheesydevs.minetopia.api.utils.Chat;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiHelper {

    public static ItemStack getItem(Material material, String displayName) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        if(itemMeta == null) return null;
        itemMeta.setDisplayName(Chat.color(displayName));
        item.setItemMeta(itemMeta);
        return item;
    }

}
