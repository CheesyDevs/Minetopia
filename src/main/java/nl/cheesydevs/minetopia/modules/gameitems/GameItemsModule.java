package nl.cheesydevs.minetopia.modules.gameitems;

import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.gameitems.commands.GameItemsCMD;
import nl.cheesydevs.minetopia.utils.files.GameItemsFile;
import nl.cheesydevs.minetopia.utils.version.command.Command;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsModule extends MinetopiaModule {

    @Override
    public String name() {
        return "GameItems";
    }

    @Override
    public void onEnable() {
        GameItemsFile.setup();
        registerCommands();
    }

    private void registerCommands() {
        Command.register(new GameItemsCMD("gameitems"));
    }
}
