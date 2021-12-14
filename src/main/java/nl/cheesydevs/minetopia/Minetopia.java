package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.api.API;
import nl.cheesydevs.minetopia.api.events.OnModuleDisableEvent;
import nl.cheesydevs.minetopia.api.events.OnModuleEnableEvent;
import nl.cheesydevs.minetopia.listeners.InventoryClick;
import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.bank.BankModule;
import nl.cheesydevs.minetopia.modules.core.CoreModule;
import nl.cheesydevs.minetopia.modules.gameitems.GameItemsModule;
import nl.cheesydevs.minetopia.modules.scoreboard.ScoreBoardModule;
import nl.cheesydevs.minetopia.utils.*;
import nl.cheesydevs.minetopia.utils.files.Config;
import nl.cheesydevs.minetopia.utils.files.ModulesFile;
import nl.cheesydevs.minetopia.utils.version.VersionManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class Minetopia extends JavaPlugin {

    /* TODO:
    Working on atm system
    Working on rekening maak command
     */

    /*
            (PreviousVersion-NewVersion)
    LAST CHANGES: (V0.0.6-V0.0.7)
    Added a Gui system
    Added GuiSize system to get the size of a gui easy
    Added startup messages
    Added rekening api and file
    Fixed ATMMainMenu with new gui system
     */
    private static API api;
    private static Minetopia instance;
    private static final List<MinetopiaModule> modules = new ArrayList<>();

    @Override
    public void onLoad() {
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
        // extra's
        VersionManager.setup();
        Config.setup();
        api = new API();
        API.setup();

        // Modules file
        ModulesFile.setup();
    }

    @Override
    public void onEnable() {
        // Checking vault dependency
        Message.startupHeader();
        if(!Vault.setupEconomy()) {
            getLogger().severe("Vault is not setup correctly. Did you install essentials?");
            getPluginLoader().disablePlugin(this);
            return;
        }
        if(getApi().getSettings().getDebug()) {
            getLogger().info(" "); // empty line for organization
        }
        // Modules
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new InventoryClick(), Minetopia.getInstance());
        loadModules(new CoreModule(), new GameItemsModule(), new ScoreBoardModule(), new BankModule());

        // extra's
        new Metrics(this, 13543);
        Message.startupFooter();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        for (MinetopiaModule module : getModules()) {
            // not calling unloadModule() because it doesn't need to call the event
            if(modules.contains(module)) {
                module.onDisable();
            } else {
                getInstance().getLogger().severe("Cannot disable module... Not loaded ["+module.name()+"]");
            }
        }
    }

    /**
     * Load a new module
     * @param module the module you want to load
     */
    public static void loadModule(MinetopiaModule module) {
        if(!modules.contains(module)) {
            if(!ModulesFile.getConfig().contains(module.name())) {ModulesFile.getConfig().set(module.name(), true);ModulesFile.save();}
            if(ModulesFile.getConfig().getBoolean(module.name()) || module.name().equals("Core")) {
                OnModuleEnableEvent onModuleEnableEvent = new OnModuleEnableEvent(module);
                Bukkit.getPluginManager().callEvent(onModuleEnableEvent);
                if (!onModuleEnableEvent.isCancelled()) {
                    if(getApi().getSettings().getDebug()) {
                        Minetopia.getInstance().getLogger().info("Enabling module "+module.name());
                    }
                    modules.add(module);
                    module.onEnable();
                }
            }
        } else {
            getInstance().getLogger().severe("Double module... Not enabling ["+module.name()+"]");
        }
    }

    /**
     * Load a new modules
     * @param modules the modules you want to load
     */
    public static void loadModules(MinetopiaModule... modules) {
        for (MinetopiaModule module : modules) {
            loadModule(module);
        }
    }

    /**
     * unLoad a new module
     * @param module the module you want to unload
     */
    public static void unloadModule(MinetopiaModule module) {
        if(modules.contains(module)) {
            OnModuleDisableEvent onModuleDisableEvent = new OnModuleDisableEvent(module);
            Bukkit.getPluginManager().callEvent(onModuleDisableEvent);
            if (!onModuleDisableEvent.isCancelled()) {
                if(getApi().getSettings().getDebug()) {
                    Minetopia.getInstance().getLogger().info("Disabling module "+module.name());
                }
                modules.remove(module);
                module.onDisable();
            }
        } else {
            getInstance().getLogger().severe("Cannot disable module... Not loaded ["+module.name()+"]");
        }
    }

    /**
     * unLoad a new modules
     * @param modules the modules you want to unload
     */
    public static void unloadModules(MinetopiaModule... modules) {
        for (MinetopiaModule module : modules) {
            unloadModule(module);
        }
    }

    /**
     * reload a module
     * @param module the module you want to reload
     */
    public static void reloadModule(MinetopiaModule module) {
        if(modules.contains(module)) {
            if(!ModulesFile.getConfig().contains(module.name())) {ModulesFile.getConfig().set(module.name(), true);ModulesFile.save();}
            if(ModulesFile.getConfig().getBoolean(module.name()) || module.name().equals("Core")) {
                OnModuleDisableEvent onModuleDisableEvent = new OnModuleDisableEvent(module);
                Bukkit.getPluginManager().callEvent(onModuleDisableEvent);
                if (!onModuleDisableEvent.isCancelled()) {
                    if(getApi().getSettings().getDebug()) {
                        Minetopia.getInstance().getLogger().info("Disabling module "+module.name());
                    }
                    module.onDisable();
                }
            }
        } else {
            getInstance().getLogger().severe("Cannot disable module... Not loaded ["+module.name()+"]");
        }
        OnModuleEnableEvent onModuleEnableEvent = new OnModuleEnableEvent(module);
        Bukkit.getPluginManager().callEvent(onModuleEnableEvent);
        if(!onModuleEnableEvent.isCancelled()) {
            if(getApi().getSettings().getDebug()) {
                Minetopia.getInstance().getLogger().info("Enabling module "+module.name());
            }
            module.onEnable();
        }
    }

    /**
     * reload modules
     * @param modules the modules you want to reload
     */
    public static void reloadModules(MinetopiaModule... modules) {
        for (MinetopiaModule module : modules) {
            reloadModule(module);
        }
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

    /**
     * Get the api of this plugin
     * @return the api
     */
    public static API getApi() {
        return api;
    }
    public static String getModulesString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Module module : Minetopia.getModules()) {
            stringBuilder.append("&f, &a").append(module.name());
        }
        return Chat.color("Modules ("+Minetopia.getModules().size()+"): "+stringBuilder.substring(4));
    }
    public static List<MinetopiaModule> getModules() {
        return modules;
    }
    public static Minetopia getInstance() {
        return instance;
    }
}
