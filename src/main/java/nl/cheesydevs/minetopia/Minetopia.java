package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.CoreModule;
import nl.cheesydevs.minetopia.utils.*;
import nl.cheesydevs.minetopia.utils.files.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Minetopia extends JavaPlugin {

    /*
    TODO:
    Working on multiple version nms
    */

    /*
            (PreviousVersion-NewVersion)
    LAST CHANGES: (V0.0.2-V0.0.2)
    Fixed vault
    */

    private static Minetopia instance;
    private static final List<Module> modules = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        if(!getDescription().getAuthors().contains("GameHugo_") || !getDescription().getAuthors().contains("patatje")) {
            getLogger().severe("You removed the real authors from the plugin.yml... Not cool bro.");
            getPluginLoader().disablePlugin(this);
            return;
        }
        if(!checkDependency()) {
            getPluginLoader().disablePlugin(this);
            return;
        }
        Config.setup();
        VersionManager.setup();
        if(!Vault.setupEconomy()) {
            getLogger().severe("Vault is not setup correctly. Did you install essentials?");
            getPluginLoader().disablePlugin(this);
            return;
        }
        Chat.setupPlaceholders();
        Scoreboard.setup();

        loadModules(new CoreModule());
    }

    public static void loadModule(Module module) {
        if(!modules.contains(module)) {
            modules.add(module);
            module.onEnable();
        } else {
            getInstance().getLogger().severe("Double module... Not enabling ["+module.name()+"]");
        }
    }

    public static void loadModules(Module... modules) {
        for (Module module : modules) {
            loadModule(module);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean checkDependency() {
        // using x to check all dependency's, then sending all the missing and then disable
        boolean x = true;
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            Message.errorDependencyNotFound("Vault");
            x = false;
        }
        if (getServer().getPluginManager().getPlugin("WorldEdit") == null) {
            Message.errorDependencyNotFound("WorldEdit");
            x = false;
        }
        if (getServer().getPluginManager().getPlugin("WorldGuard") == null) {
            Message.errorDependencyNotFound("WorldGuard");
            x = false;
        }
        return x;
    }

    public static List<Module> getModules() {
        return modules;
    }
    public static Minetopia getInstance() {
        return instance;
    }
}
