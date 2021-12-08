package nl.cheesydevs.minetopia.modules.core.commands.subcommands;

import nl.cheesydevs.minetopia.modules.core.commands.MoneyCMD;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommand;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandExecutor;
import org.bukkit.command.CommandSender;

@SubCommand(name = "test", description = "testing", usage = "test")
public class SubTest implements SubCommandExecutor {

    @Override
    public String getCommand() {
        return MoneyCMD.class.toString();
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage("werkt");
        return true;
    }
}
