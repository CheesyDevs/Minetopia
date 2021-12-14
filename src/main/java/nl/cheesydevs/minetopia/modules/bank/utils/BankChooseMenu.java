package nl.cheesydevs.minetopia.modules.bank.utils;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import nl.cheesydevs.minetopia.utils.interfaces.*;
import nl.cheesydevs.minetopia.utils.version.nbt.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BankChooseMenu extends MinetopiaGui {

    @Override
    public String getTitle() {
        return LanguageFile.get("SelectRekening");
    }

    @Override
    public int getSize() {
        return new GuiSlots(3).toInteger();
    }

    @Override
    public Inventory getInventory(Player player) {
        ChestGui gui = new ChestGui(this);
        int slot = 0;
        for (Rekening rekening : Minetopia.getApi().getBanking().getPlayerRekening(player)) {
            ItemStack item = new ItemStack(Material.BARRIER);
            if(rekening.getRekeningType().equals(RekeningType.PERSONAL)) item = new ItemStack(Material.DIAMOND_BLOCK);
            if(rekening.getRekeningType().equals(RekeningType.COMPANY)) item = new ItemStack(Material.GOLD_BLOCK);
            if(rekening.getRekeningType().equals(RekeningType.SAVINGS)) item = new ItemStack(Material.REDSTONE_BLOCK);
            ItemMeta itemMeta = item.getItemMeta();
            if(itemMeta != null) {
                itemMeta.setDisplayName(rekening.getName());
                List<String> lore = new ArrayList<>();
                lore.add("ID: "+rekening.getRekeningID());
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                NBT.set(item, "id", String.valueOf(rekening.getRekeningID()));
                Minetopia.getInstance().getLogger().info(String.valueOf(rekening.getRekeningID()));
                gui.setItem(slot, item);
                slot++;
            }
        }
        return gui.getInventory();
    }

    @Override
    public boolean cancelItemClick() {
        return true;
    }

    @Override
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LanguageFile.get("SpaarRekening"))) {
            e.getWhoClicked().openInventory(new BankRekeningMenu().getInventory());
        }
    }


}
