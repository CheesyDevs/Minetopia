package nl.cheesydevs.minetopia.modules.bank.utils;

import nl.cheesydevs.minetopia.api.utils.bank.RekeningType;
import nl.cheesydevs.minetopia.modules.bank.utils.choosemenu.BankCompanyMenu;
import nl.cheesydevs.minetopia.modules.bank.utils.choosemenu.BankPersonalMenu;
import nl.cheesydevs.minetopia.modules.bank.utils.choosemenu.BankSavingsMenu;
import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import nl.cheesydevs.minetopia.utils.interfaces.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

@SuppressWarnings("SpellCheckingInspection")
public class BankMainMenu extends MinetopiaGui {

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
        if(!(e.getWhoClicked() instanceof Player)) return;
        if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LanguageFile.get("SpaarRekening"))) {
            openInv((Player) e.getWhoClicked(), RekeningType.SAVINGS);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LanguageFile.get("PriveRekenking"))) {
            openInv((Player) e.getWhoClicked(), RekeningType.PERSONAL);
        } else if(e.getCurrentItem().getItemMeta().getDisplayName().equals(LanguageFile.get("BedrijfsRekening"))) {
            openInv((Player) e.getWhoClicked(), RekeningType.COMPANY);
        }
    }

    private void openInv(Player player, RekeningType rekeningType) {
        if(rekeningType.equals(RekeningType.SAVINGS)) {
            Inventory inv = new BankSavingsMenu().getInventory(player);
            if (inv != null) {
                player.openInventory(new BankSavingsMenu().getInventory(player));
            } else {
                player.sendMessage(LanguageFile.get("NoSpaarRekening"));
            }
        } else if(rekeningType.equals(RekeningType.PERSONAL)) {
            Inventory inv = new BankPersonalMenu().getInventory(player);
            if (inv != null) {
                player.openInventory(new BankPersonalMenu().getInventory(player));
            } else {
                player.sendMessage(LanguageFile.get("NoPriveRekening"));
            }
        } else if(rekeningType.equals(RekeningType.COMPANY)) {
            Inventory inv = new BankCompanyMenu().getInventory(player);
            if (inv != null) {
                player.openInventory(new BankCompanyMenu().getInventory(player));
            } else {
                player.sendMessage(LanguageFile.get("NoBedrijfsRekening"));
            }
        }
    }
}
