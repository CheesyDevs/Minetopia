package nl.cheesydevs.minetopia.modules.atm;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.atm.commands.OpenBankCMD;
import nl.cheesydevs.minetopia.modules.atm.listeners.ATMInventoryClick;
import nl.cheesydevs.minetopia.utils.version.command.Command;

@SuppressWarnings("SpellCheckingInspection")
public class ATMModule extends MinetopiaModule {

    @Override
    public String name() {
        return "ATM";
    }

    @Override
    public void onEnable() {
        registerCommands();
        registerEvents();
    }

    private void registerCommands() {
        Command.register(new OpenBankCMD("openbank"));
    }
    private void registerEvents() {
        Minetopia.getInstance().getServer().getPluginManager().registerEvents(new ATMInventoryClick(), Minetopia.getInstance());
    }
}
