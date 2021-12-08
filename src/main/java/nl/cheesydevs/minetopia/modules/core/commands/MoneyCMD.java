package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Vault;
import nl.cheesydevs.minetopia.utils.interfaces.SubCommandManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class MoneyCMD extends BukkitCommand {
    public MoneyCMD(String name) {
        super(name);
        this.description = "Money";
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(SubCommandManager.execute(sender, args, this.getClass(), 0)) {
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

