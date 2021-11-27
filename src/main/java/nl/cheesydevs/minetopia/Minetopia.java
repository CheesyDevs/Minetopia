package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.Commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.Commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.Utils.*;
import nl.cheesydevs.minetopia.Utils.Files.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Minetopia extends JavaPlugin {

    /*
            (PreviousVersion-NewVersion)
    LAST CHANGES: (V0.0.1-V0.0.2)
    Changed Minecraft version to 1.16
    Changed dependency system to softDepend and added a check in onEnable()
    Added WorldEdit dependency
    Added JoinLeave Messages
    Added Config File
    Added a part of scoreboard system
    */

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
        checkDependency();
        Config.setup();
        VersionManager.setup();
        Vault.setupEconomy();
        Chat.setupPlaceholders();
        Scoreboard.setup();

        setupCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void checkDependency() {
        boolean x = false;
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            Message.errorDependencyNotFound("Vault");
            x = true;
        }
        if (getServer().getPluginManager().getPlugin("WorldEdit") == null) {
            Message.errorDependencyNotFound("WorldEdit");
            x = true;
        }
        if (getServer().getPluginManager().getPlugin("WorldGuard") == null) {
            Message.errorDependencyNotFound("WorldGuard");
            x = true;
        }
        if(x) {
            getPluginLoader().disablePlugin(this);
        }
    }

    private void setupCommands() {
        Objects.requireNonNull(getCommand("minetopia")).setExecutor(new MinetopiaCMD());
        Objects.requireNonNull(getCommand("scoreboard")).setExecutor(new ScoreboardCMD());
    }

    public static Minetopia getInstance() {
        return instance;
    }
}
