package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ChestGui {
    private final Gui gui;
    HashMap<Integer, ItemStack> slots = new HashMap<>();
    public ChestGui(Gui gui) {
        this.gui = gui;
    }

    public Inventory getInventory() {
        Inventory inventory = Bukkit.createInventory(null, gui.getSize(), gui.getTitle());
        for(int slot : slots.keySet()) {
            inventory.setItem(slot, slots.get(slot));
        }
        return inventory;
    }

    public void setItem(int slot, ItemStack itemStack) {
        slots.remove(slot); // for no duplicated slots
        slots.put(slot, itemStack);
    }

    public ItemStack getItem(int slot) {
        return slots.get(slot);
    }
}
