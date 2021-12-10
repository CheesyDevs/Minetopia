package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.events.OnModuleDisableEvent;
import nl.cheesydevs.minetopia.events.OnModuleEnableEvent;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.CoreModule;
import nl.cheesydevs.minetopia.modules.gameitems.GameItemsModule;
import nl.cheesydevs.minetopia.utils.*;
import nl.cheesydevs.minetopia.utils.files.Config;
import nl.cheesydevs.minetopia.utils.files.GameItemsFile;
import nl.cheesydevs.minetopia.utils.version.VersionManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Minetopia extends JavaPlugin {

    /*
            (PreviousVersion-NewVersion)
    LAST CHANGES: (V0.0.2-V0.0.4)
    Added too much lol...
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
        // Checking Dependency's
        if(!checkDependency()) {
            getPluginLoader().disablePlugin(this);
            return;
        }
        if(!Vault.setupEconomy()) {
            getLogger().severe("Vault is not setup correctly. Did you install essentials?");
            getPluginLoader().disablePlugin(this);
            return;
        }

        // Files
        Config.setup();
        GameItemsFile.setup();

        // extra's
        VersionManager.setup();
        Chat.setupPlaceholders();
        Scoreboard.setup();
        new Metrics(this, 13543);

        // Modules
        loadModules(new CoreModule(), new GameItemsModule());
    }

    public static void loadModule(Module module) {
        if(!modules.contains(module)) {
            OnModuleEnableEvent onModuleEnableEvent = new OnModuleEnableEvent(module);
            Bukkit.getPluginManager().callEvent(onModuleEnableEvent);
            if(!onModuleEnableEvent.isCancelled()) {
                modules.add(module);
                module.onEnable();
            }
        } else {
            getInstance().getLogger().severe("Double module... Not enabling ["+module.name()+"]");
        }
    }

    public static void loadModules(Module... modules) {
        for (Module module : modules) {
            loadModule(module);
        }
    }

    public static void unloadModule(Module module) {
        if(modules.contains(module)) {
            OnModuleDisableEvent onModuleDisableEvent = new OnModuleDisableEvent(module);
            Bukkit.getPluginManager().callEvent(onModuleDisableEvent);
            if (!onModuleDisableEvent.isCancelled()) {
                modules.remove(module);
                module.onDisable();
            }
        } else {
            getInstance().getLogger().severe("Cannot disable module... Not loaded ["+module.name()+"]");
        }
    }

    public static void unloadModules(Module... modules) {
        for (Module module : modules) {
            unloadModule(module);
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

    public static String getModulesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Module module : Minetopia.getModules()) {
            stringBuilder.append("&f, &a").append(module.name());
        }
        return Chat.color("Modules ("+Minetopia.getModules().size()+"): "+stringBuilder.substring(4));
    }
    public static List<Module> getModules() {
        return modules;
    }
    public static Minetopia getInstance() {
        return instance;
    }
}
