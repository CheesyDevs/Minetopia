package nl.cheesydevs.minetopia.modules.bank.commands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.bank.utils.RekeningType;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RekeningCMD extends BukkitCommand {

    public RekeningCMD(String name) {
        super(name);
        setDescription("rekening");
        setPermission("minetopia.rekening");
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!sender.hasPermission(Objects.requireNonNull(getPermission()))) return false;
        Player p = (Player) sender;
        List<OfflinePlayer> players = new ArrayList<>();players.add(p);
        Minetopia.getApi().getBanking().makeRekening(RekeningType.PERSONAL, p, players);
        return true;
    }
}
