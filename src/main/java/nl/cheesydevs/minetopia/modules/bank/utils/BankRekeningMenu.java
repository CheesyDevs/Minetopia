package nl.cheesydevs.minetopia.modules.bank.utils;

import nl.cheesydevs.minetopia.utils.interfaces.*;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class BankRekeningMenu extends MinetopiaGui {

    @Override
    public String getTitle() {
        return "b";
    }

    @Override
    public int getSize() {
        return new GuiSlots(6).toInteger();
    }

    @Override
    public Inventory getInventory() {
        ChestGui gui = new ChestGui(this);
        for (int i = 0; i < 9; i++) {
            gui.setItem(new GuiSlots(5, i).toInteger(), GuiHelper.getItem(Material.PURPLE_STAINED_GLASS_PANE, " "));
        }
        return gui.getInventory();
    }

    @Override
    public boolean cancelItemClick() {
        return true;
    }

    @Override
    public void onInventoryClickEvent(InventoryClickEvent e) {

    }
}
