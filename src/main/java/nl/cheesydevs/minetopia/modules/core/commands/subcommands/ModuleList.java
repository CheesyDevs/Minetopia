package nl.cheesydevs.minetopia.modules.core.commands.subcommands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.core.commands.ModuleCMD;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommand;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandExecutor;
import org.bukkit.command.CommandSender;

@SubCommand(name = "list", description = "See all modules", usage = "list")
public class ModuleList implements SubCommandExecutor {
    @Override
    public String getCommand() {
        return ModuleCMD.class.toString();
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(Minetopia.getModulesString());
        return true;
    }
}
