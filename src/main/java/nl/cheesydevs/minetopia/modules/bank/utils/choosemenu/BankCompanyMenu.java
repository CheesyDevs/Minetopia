package nl.cheesydevs.minetopia.modules.bank.utils.choosemenu;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.api.utils.bank.Rekening;
import nl.cheesydevs.minetopia.api.utils.bank.RekeningType;
import nl.cheesydevs.minetopia.modules.bank.utils.BankRekeningMenu;
import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import nl.cheesydevs.minetopia.utils.interfaces.ChestGui;
import nl.cheesydevs.minetopia.utils.interfaces.GuiSlots;
import nl.cheesydevs.minetopia.utils.interfaces.MinetopiaGui;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class BankCompanyMenu extends MinetopiaGui {

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
        return BankChooseMenu.getInventory(player, new ChestGui(this), RekeningType.COMPANY);
    }

    @Override
    public boolean cancelItemClick() {
        return true;
    }

    @Override
    public void onInventoryClickEvent(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getItemMeta() == null) return;
        boolean equals = false;
        for (Rekening rekening : Minetopia.getApi().getBanking().getPlayerRekening((Player)e.getWhoClicked(), RekeningType.COMPANY)) {
            if(rekening.getName().equals(e.getCurrentItem().getItemMeta().getDisplayName())) {
                equals = true;
                break;
            }
        }
        if(equals) {
            e.getWhoClicked().openInventory(new BankRekeningMenu().getInventory());
        }
    }


}
