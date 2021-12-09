package nl.cheesydevs.minetopia.modules.gameitems;

import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.gameitems.commands.GameItemsCMD;
import nl.cheesydevs.minetopia.utils.command.CommandManager;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsModule implements Module {

    @Override
    public String name() {
        return "GameItems";
    }

    @Override
    public void onEnable() {
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        CommandManager.register(new GameItemsCMD("gameitems"));
    }
}
