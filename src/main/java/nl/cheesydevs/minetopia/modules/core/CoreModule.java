package nl.cheesydevs.minetopia.modules.core;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.modules.core.commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.utils.VersionManager;

public class CoreModule implements Module {

    Minetopia minetopia = Minetopia.getInstance();

    @Override
    public String name() {
        return "Core";
    }

    @Override
    public void onEnable() {
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        VersionManager.getServer().getCommandMap().register("minetopia", new MinetopiaCMD("minetopia"));
        VersionManager.getServer().getCommandMap().register("scoreboard", new ScoreboardCMD("scoreboard"));
        VersionManager.getServer().getCommandMap().register("minetopia", new MinetopiaCMD("minetopia"));
    }
}
