package nl.cheesydevs.minetopia.modules.bank;

import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.bank.commands.OpenBankCMD;
import nl.cheesydevs.minetopia.modules.bank.commands.RekeningCMD;
import nl.cheesydevs.minetopia.modules.bank.utils.BankChooseMenu;
import nl.cheesydevs.minetopia.modules.bank.utils.BankMainMenu;
import nl.cheesydevs.minetopia.modules.bank.utils.BankRekeningMenu;
import nl.cheesydevs.minetopia.utils.interfaces.GuiManager;
import nl.cheesydevs.minetopia.utils.version.command.Command;

@SuppressWarnings("SpellCheckingInspection")
public class BankModule extends MinetopiaModule {

    @Override
    public String name() {
        return "Bank";
    }

    @Override
    public void onEnable() {
        register();
    }

    private void register() {
        Command.register(new OpenBankCMD("openbank"));
        Command.register(new RekeningCMD("rekening"));
        GuiManager.register(new BankMainMenu());
        GuiManager.register(new BankChooseMenu());
        GuiManager.register(new BankRekeningMenu());
    }
}
