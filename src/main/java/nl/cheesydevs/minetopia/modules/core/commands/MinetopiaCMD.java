package nl.cheesydevs.minetopia.modules.core.commands;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;

public class MinetopiaCMD extends BukkitCommand {
    public MinetopiaCMD(String name) {
        super(name);
        this.description = "The main command of the plugin";
        ArrayList<String> aliases = new ArrayList<>();aliases.add("mt");
        this.setAliases(aliases);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
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
