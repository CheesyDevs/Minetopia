package nl.cheesydevs.minetopia.api.utils;

import net.milkbowl.vault.economy.Economy;
import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.text.NumberFormat;
import java.util.Locale;

public class Vault {

    private static Economy economy = null; // default is null

    public static boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = Minetopia.getInstance().getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return true;
    }

    public static String getBalanceFormatted(OfflinePlayer offlinePlayer) {
        String s = NumberFormat.getCurrencyInstance(Locale.GERMAN).format(getEconomy().getBalance(offlinePlayer));
        return s.substring(0, s.length()-2);
    }

    public static Economy getEconomy() {
        if(economy == null) {
            setupEconomy();
        }
        return economy;
    }
}
