package nl.cheesydevs.minetopia.modules.core;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.modules.core.commands.ModuleCMD;
import nl.cheesydevs.minetopia.modules.core.commands.MoneyCMD;
import nl.cheesydevs.minetopia.modules.core.commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.modules.core.commands.subcommands.ModuleList;
import nl.cheesydevs.minetopia.modules.core.commands.subcommands.SubTest;
import nl.cheesydevs.minetopia.modules.core.listeners.OnJoinQuit;
import nl.cheesydevs.minetopia.utils.command.CommandManager;
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
        CommandManager.register(new MinetopiaCMD("minetopia"));
        CommandManager.register(new ScoreboardCMD("scoreboard"));
        CommandManager.register(new MoneyCMD("money"));
        SubCommandManager.addSubCommand(MoneyCMD.class.toString(), new SubTest());
        CommandManager.register(new ModuleCMD("module"));
        SubCommandManager.addSubCommand(ModuleCMD.class.toString(), new ModuleList());
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new OnJoinQuit(), Minetopia.getInstance());
    }
}
