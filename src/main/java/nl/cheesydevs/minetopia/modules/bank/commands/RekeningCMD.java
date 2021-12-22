package nl.cheesydevs.minetopia.modules.bank.commands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.api.utils.bank.RekeningType;
import nl.cheesydevs.minetopia.api.utils.Chat;
import org.bukkit.Bukkit;
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

    private void help(CommandSender sender) {
        sender.sendMessage(Chat.color("&c/rekening maak <RekeningType> <Player>"));
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!sender.hasPermission(Objects.requireNonNull(getPermission()))) return false;
        if(args.length > 0) {
            // rekening maak <RekeningType> <Player>
            if(args[0].equalsIgnoreCase("maak")) {
                if(args.length == 3) {
                    if(!RekeningType.exists(args[1])) {sender.sendMessage("RekeningType not existing");return false;}
                    if(Bukkit.getPlayer(args[2]) == null) {sender.sendMessage("Player not online"); return false;}
                    Player target = Bukkit.getPlayer(args[2]);
                    List<OfflinePlayer> players = new ArrayList<>();players.add(target);
                    Minetopia.getApi().getBanking().makeRekening(RekeningType.get(args[1]), target, players);
                    sender.sendMessage(Chat.color("&aMade rekening with id "+Minetopia.getApi().getBanking().getLastRekeningId()));
                } else {
                    // help message for maak (rekening maak <RekeningType> <Player>)
                    sender.sendMessage(Chat.color("&c/rekening maak <RekeningType> <Player>"));
                }
            } else {
                help(sender);
            }
        } else {
            help(sender);
        }
        return true;
    }
}
