package nl.cheesydevs.minetopia;

import nl.cheesydevs.minetopia.listeners.InventoryClick;
import nl.cheesydevs.minetopia.modules.AddonCore;
import nl.cheesydevs.minetopia.utils.*;
import nl.cheesydevs.minetopia.utils.files.ModulesFile;
import nl.cheesydevs.minetopia.utils.version.VersionManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

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
    private static Minetopia instance;

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

        // Modules file
        ModulesFile.setup();
    }

    @Override
    public void onEnable() {
        // Checking vault dependency
        Message.startupHeader();
        if(!checkDependency()) {
            getPluginLoader().disablePlugin(this);
            return;
        }
        if(!Vault.setupEconomy()) {
            getLogger().severe("Vault is not setup correctly. Did you install essentials?");
            getPluginLoader().disablePlugin(this);
            return;
        }

        // Modules
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new InventoryClick(), Minetopia.getInstance());
        new AddonCore().enable();

        // extra's
        new Metrics(this, 13543);
        Message.startupFooter();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //for (MinetopiaModule module : getModules()) {
        //    // not calling unloadModule() because it doesn't need to call the event
        //    if(modules.contains(module)) {
        //        module.onDisable();
        //    } else {
        //        getInstance().getLogger().severe("Cannot disable module... Not loaded ["+module.name()+"]");
        //    }
        //}
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
    public static Minetopia getInstance() {
        return instance;
    }
}
