package nl.cheesydevs.minetopia.modules.gameitems;

import nl.cheesydevs.minetopia.modules.Module;
import nl.cheesydevs.minetopia.modules.gameitems.commands.GameItemsCMD;
import nl.cheesydevs.minetopia.utils.files.GameItemsFile;
import nl.cheesydevs.minetopia.utils.version.command.Command;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsModule implements Module {

    @Override
    public String name() {
        return "GameItems";
    }

    @Override
    public void onEnable() {
        GameItemsFile.setup();
        registerCommands();
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        Command.register(new GameItemsCMD("gameitems"));
    }
}
