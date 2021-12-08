package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Vault;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommand;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandExecutor;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class MoneyCMD extends BukkitCommand {
    public MoneyCMD(String name) {
        super(name);
        this.description = "Money";
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(args.length > 0) {
            for (SubCommandExecutor subCommandExecutor : SubCommandManager.getSubCommands().values()) {
                if(subCommandExecutor.getCommand().equals(this.getClass().toString())) {
                    if(subCommandExecutor.getClass().getAnnotation(SubCommand.class).name().equals(args[0]) && args.length == subCommandExecutor.getClass().getAnnotation(SubCommand.class).argsLength()) {
                        return subCommandExecutor.execute(sender, args);
                    }
                }
            }
        }
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("Geld: "+ Vault.getBalanceFormatted(p));
        }
        return false;
    }

}

