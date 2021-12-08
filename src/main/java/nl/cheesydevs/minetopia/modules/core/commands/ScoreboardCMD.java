package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Scoreboard;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ScoreboardCMD extends BukkitCommand {
    public ScoreboardCMD(String name) {
        super(name);
        this.description = "Toggle the scoreboard";
        ArrayList<String> aliases = new ArrayList<>();aliases.add("sb");
        this.setAliases(aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Scoreboard.update(p);
            sender.sendMessage("updated");
        }
        return true;
    }
}
