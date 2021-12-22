package nl.cheesydevs.minetopia.modules.scoreboard.commands;

import nl.cheesydevs.minetopia.modules.scoreboard.utils.Scoreboard;
import nl.cheesydevs.minetopia.utils.files.LanguageFile;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;

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
                p.sendMessage(LanguageFile.get("ScoreboardDisabled"));
            } else {
                Scoreboard.add(p);
                p.sendMessage(LanguageFile.get("ScoreboardEnabled"));
            }
        }
        return true;
    }
}
