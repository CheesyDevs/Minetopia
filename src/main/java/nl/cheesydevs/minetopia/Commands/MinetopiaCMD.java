package nl.cheesydevs.minetopia.Commands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.Utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MinetopiaCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("minetopia.use")) {
            sender.sendMessage(Chat.color("&6This minetopia plugin is made by &e"+getAuthors()+"\n&6Website: &ehttps://cheesydevs.nl"));
            return true;
        }
        sender.sendMessage(Chat.color("&6This command is coming soon"));
        return true;
    }

    private String getAuthors() {
        return Minetopia.getInstance().getDescription().getAuthors().toString().substring(1, Minetopia.getInstance().getDescription().getAuthors().toString().length()-1);
    }
}
