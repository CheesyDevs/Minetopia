package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Vault;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class MoneyCMD extends BukkitCommand {
    public MoneyCMD(String name) {
        super(name);
        this.description = "Testing command";
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("Geld: "+ Vault.getBalanceFormatted(p));
        }
        return false;
    }
}
