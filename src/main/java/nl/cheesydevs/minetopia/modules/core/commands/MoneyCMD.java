package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Vault;
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
        if(SubCommandManager.execute(sender, args, this.getClass(), 1)) {
            return true;
        }
        if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("Geld: "+ Vault.getBalanceFormatted(p));
            return true;
        }
        return false;
    }

}

