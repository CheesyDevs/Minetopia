package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.Utils.Vault;
import nl.cheesydevs.minetopia.Utils.VersionManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minetopia extends JavaPlugin {

    private static Minetopia instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Vault.setupEconomy();
        VersionManager.setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Minetopia getInstance() {
        return instance;
    }
}
