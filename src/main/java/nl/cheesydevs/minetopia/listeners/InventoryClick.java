package nl.cheesydevs.minetopia.listeners;

import nl.cheesydevs.minetopia.utils.interfaces.Gui;
import nl.cheesydevs.minetopia.utils.interfaces.GuiManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        for (Gui gui : GuiManager.getGuiList()) {
            if(e.getView().getTitle().equals(gui.getTitle())) {
                if(gui.cancelItemClick()) e.setCancelled(true);
                gui.onInventoryClickEvent(e);
            }
        }
    }
}
