package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public abstract class MinetopiaGui implements Gui {

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    @Override
    public Inventory getInventory(Player player) {
        return null;
    }

    @Override
    public boolean cancelItemClick() {
        return false;
    }

    @Override
    public void onInventoryClickEvent(InventoryClickEvent e) {

    }
}
