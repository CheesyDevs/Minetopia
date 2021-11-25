package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.Commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.Utils.Vault;
import nl.cheesydevs.minetopia.Utils.VersionManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minetopia extends JavaPlugin {

    private static Minetopia instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if(!getDescription().getAuthors().contains("GameHugo_") || !getDescription().getAuthors().contains("patatje")) {
            getLogger().severe("You removed the real authors from the plugin.yml... Not cool bro.");
            getPluginLoader().disablePlugin(this);
            return;
        }
        VersionManager.setup();
        Vault.setupEconomy();

        setupCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void setupCommands() {
        getCommand("minetopia").setExecutor(new MinetopiaCMD());
    }

    public static Minetopia getInstance() {
        return instance;
    }
}
