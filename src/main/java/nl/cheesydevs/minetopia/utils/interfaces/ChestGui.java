package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@SuppressWarnings("unused")
public class ChestGui {
    HashMap<Integer, ItemStack> slots = new HashMap<>();
    private int size;
    private String title;
    public ChestGui(Gui gui) {
        this.size = gui.getSize();
        this.title = gui.getTitle();
    }

    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, getSize(), getTitle());
        for(int slot : slots.keySet()) {
            inventory.setItem(slot, slots.get(slot));
        }
        return inventory;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setItem(int slot, ItemStack itemStack) {
        slots.remove(slot); // for no duplicated slots
        slots.put(slot, itemStack);
    }

    public int getSize() {
        return size;
    }
    public String getTitle() {
        return title;
    }
    public ItemStack getItem(int slot) {
        return slots.get(slot);
    }
}
