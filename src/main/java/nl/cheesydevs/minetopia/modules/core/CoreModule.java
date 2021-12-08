package nl.cheesydevs.minetopia.modules.core;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.modules.core.commands.MoneyCMD;
import nl.cheesydevs.minetopia.modules.core.commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.modules.core.commands.subcommands.SubTest;
import nl.cheesydevs.minetopia.modules.core.listeners.OnJoinQuit;
import nl.cheesydevs.minetopia.utils.VersionManager;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandManager;

public class CoreModule implements Module {

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
        VersionManager.getServer().getCommandMap().register("money", new MoneyCMD("money"));
        SubCommandManager.addSubCommand(MoneyCMD.class.toString(), new SubTest());
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new OnJoinQuit(), Minetopia.getInstance());
    }
}
