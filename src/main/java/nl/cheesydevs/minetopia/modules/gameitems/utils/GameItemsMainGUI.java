package nl.cheesydevs.minetopia.modules.gameitems.utils;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.api.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.GameItemsFile;
import nl.cheesydevs.minetopia.utils.version.nbt.NBT;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsMainGUI {

    public static Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, 3*9, Chat.color(""));

        int slot = 0;
        for (String id : GameItemsFile.getConfig().getKeys(false)) {
            if(GameItemsFile.getConfig().get(id+".Item") == null) {Minetopia.getInstance().getLogger().severe(id+" in gameitems.yml is missing information.");continue;}
            if(Material.getMaterial(Objects.requireNonNull(Objects.requireNonNull(GameItemsFile.getConfig().getString(id + ".Item")).toUpperCase())) == null) {Minetopia.getInstance().getLogger().severe(id+" in gameitems.yml has a invalid item.");continue;}
            ItemStack item = new ItemStack(Objects.requireNonNull(Material.getMaterial(Objects.requireNonNull(Objects.requireNonNull(GameItemsFile.getConfig().getString(id + ".Item")).toUpperCase()))));
            ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta == null) {Minetopia.getInstance().getLogger().severe("There is something wrong with "+id+" in gameitems.yml please check.");continue;}
            if(GameItemsFile.getConfig().get(id+".DisplayName") != null) {
                itemMeta.setDisplayName(Chat.color(GameItemsFile.getConfig().getString(id + ".DisplayName")));
            }
            item.setItemMeta(itemMeta);
            if(GameItemsFile.getConfig().getString(id + ".NBTTag") != null) {
                String[] parts = Objects.requireNonNull(GameItemsFile.getConfig().getString(id + ".NBTTag")).split(":");
                String tag = parts[0];
                String definition = parts[1];
                item = NBT.set(item, tag, definition);
            }
            inventory.setItem(slot, item);
            slot++;
        }
        return inventory;
    }

}
