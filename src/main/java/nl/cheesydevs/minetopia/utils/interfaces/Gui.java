package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface Gui {
    String getTitle();
    int getSize();
    Inventory getInventory();
    boolean cancelItemClick();
    void onInventoryClickEvent(InventoryClickEvent e);
}
