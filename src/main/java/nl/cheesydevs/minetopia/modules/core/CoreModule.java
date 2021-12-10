package nl.cheesydevs.minetopia.modules.core;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.core.commands.MinetopiaCMD;
import nl.cheesydevs.minetopia.modules.core.commands.ModuleCMD;
import nl.cheesydevs.minetopia.modules.core.commands.MoneyCMD;
import nl.cheesydevs.minetopia.modules.core.commands.subcommands.ModuleList;
import nl.cheesydevs.minetopia.modules.core.commands.subcommands.SubTest;
import nl.cheesydevs.minetopia.modules.core.listeners.OnJoinQuit;
import nl.cheesydevs.minetopia.utils.files.Config;
import nl.cheesydevs.minetopia.utils.files.PlayerDataFiles;
import nl.cheesydevs.minetopia.utils.version.command.Command;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandManager;

public class CoreModule implements Module {

    @Override
    public String name() {
        return "Core";
    }

    @Override
    public void onEnable() {
        Config.setup();
        PlayerDataFiles.setup();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        Command.register(new MinetopiaCMD("minetopia"));
        Command.register(new MoneyCMD("money"));
        SubCommandManager.addSubCommand(MoneyCMD.class.toString(), new SubTest());
        Command.register(new ModuleCMD("module"));
        SubCommandManager.addSubCommand(ModuleCMD.class.toString(), new ModuleList());
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new OnJoinQuit(), Minetopia.getInstance());
    }
}
