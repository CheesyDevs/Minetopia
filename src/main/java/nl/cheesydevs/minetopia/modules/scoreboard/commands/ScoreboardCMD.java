package nl.cheesydevs.minetopia.modules.scoreboard.commands;

import nl.cheesydevs.minetopia.modules.scoreboard.utils.Scoreboard;
import nl.cheesydevs.minetopia.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Objects;

public class ScoreboardCMD extends BukkitCommand {
    public ScoreboardCMD(String name) {
        super(name);
        this.description = "Toggle the scoreboard";
        ArrayList<String> aliases = new ArrayList<>();aliases.add("sb");
        this.setAliases(aliases);
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String s, @Nonnull String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(Scoreboard.getEnabled().contains(p)) {
                Scoreboard.remove(p);
                p.sendMessage(Chat.color("&aJe hebt je scoreboard uit gezet!"));
            } else {
                Scoreboard.add(p);
                p.sendMessage(Chat.color("&aJe hebt je scoreboard aan gezet!"));
            }
        }
        return true;
    }
}
