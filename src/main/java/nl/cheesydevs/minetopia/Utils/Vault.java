package nl.cheesydevs.minetopia.Utils;

import net.milkbowl.vault.economy.Economy;
import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.plugin.RegisteredServiceProvider;

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

    public static Economy getEconomy() {
        if(economy == null) {
            setupEconomy();
        }
        return economy;
    }
}
