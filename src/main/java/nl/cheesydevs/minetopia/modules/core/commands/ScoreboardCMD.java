package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.utils.Scoreboard;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreboardCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Scoreboard.update(p);
            sender.sendMessage("updated");
        }
        return false;
    }
}
