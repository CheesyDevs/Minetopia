package nl.cheesydevs.minetopia.modules.bank.utils.choosemenu;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.api.utils.bank.Rekening;
import nl.cheesydevs.minetopia.api.utils.bank.RekeningType;
import nl.cheesydevs.minetopia.utils.interfaces.*;
import nl.cheesydevs.minetopia.utils.version.nbt.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BankChooseMenu {

    public static Inventory getInventory(Player player, ChestGui chestGui, RekeningType rekeningType) {
        int slot = 0;
        ItemStack item = new ItemStack(Material.BARRIER);
        if(rekeningType.equals(RekeningType.PERSONAL)) item = new ItemStack(Material.DIAMOND_BLOCK);
        if(rekeningType.equals(RekeningType.COMPANY)) item = new ItemStack(Material.GOLD_BLOCK);
        if(rekeningType.equals(RekeningType.SAVINGS)) item = new ItemStack(Material.REDSTONE_BLOCK);
        if(Minetopia.getApi().getBanking().getPlayerRekening(player, rekeningType).isEmpty()) return null;
        for (Rekening rekening : Minetopia.getApi().getBanking().getPlayerRekening(player, rekeningType)) {
            ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta != null) {
                itemMeta.setDisplayName(rekening.getName());
                List<String> lore = new ArrayList<>();
                lore.add("ID: "+rekening.getRekeningID());
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                NBT.set(item, "id", String.valueOf(rekening.getRekeningID()));
                chestGui.setItem(slot, item);
                slot++;
            }
        }
        return chestGui.getInventory();
    }

}
