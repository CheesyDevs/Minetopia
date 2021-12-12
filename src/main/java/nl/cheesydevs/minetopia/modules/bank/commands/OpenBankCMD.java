package nl.cheesydevs.minetopia.modules.bank.commands;

import nl.cheesydevs.minetopia.modules.bank.utils.BankMainMenu;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class OpenBankCMD extends BukkitCommand {

    public OpenBankCMD(String name) {
        super(name);
        setDescription("bank");
        setPermission("minetopia.openbank");
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!sender.hasPermission(Objects.requireNonNull(getPermission()))) return false;
        Player p = (Player) sender;
        p.openInventory(new BankMainMenu().getInventory());
        return true;
    }
}
