package nl.cheesydevs.minetopia.utils.interfaces;

import nl.cheesydevs.minetopia.api.utils.bank.Rekening;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public interface Gui {
    String getTitle();
    int getSize();
    Inventory getInventory();
    Inventory getInventory(Player player);
    Inventory getInventory(Player player, Rekening rekening);
    boolean cancelItemClick();
    void onInventoryClickEvent(InventoryClickEvent e);
}
