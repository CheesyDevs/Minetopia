package nl.cheesydevs.minetopia.modules.bank.utils;

import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import nl.cheesydevs.minetopia.utils.interfaces.ChestGui;
import nl.cheesydevs.minetopia.utils.interfaces.Gui;
import nl.cheesydevs.minetopia.utils.interfaces.GuiHelper;
import nl.cheesydevs.minetopia.utils.interfaces.GuiSlots;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("SpellCheckingInspection")
public class BankMainMenu implements Gui {

    @Override
    public String getTitle() {
        return LanguageFile.get("SelectRekening");
    }

    @Override
    public int getSize() {
        return new GuiSlots(3).toInteger();
    }

    @Override
    public Inventory getInventory() {
        ChestGui gui = new ChestGui(this);
        gui.setItem(9+2, GuiHelper.getItem(Material.REDSTONE_BLOCK, LanguageFile.get("SpaarRekening")));
        gui.setItem(9+4, GuiHelper.getItem(Material.GOLD_BLOCK, LanguageFile.get("PriveRekenking")));
        gui.setItem(9+6, GuiHelper.getItem(Material.DIAMOND_BLOCK, LanguageFile.get("BedrijfsRekening")));
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
