package nl.cheesydevs.minetopia.modules.bank.listeners;

import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ATMInventoryClick implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if(e.getView().getTitle().equals(LanguageFile.get("SelectRekening"))) {
            e.setCancelled(true);
        }
    }
}
