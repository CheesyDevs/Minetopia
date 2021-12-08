package nl.cheesydevs.minetopia.utils.interfaces;

import org.bukkit.command.CommandSender;

public interface SubCommandExecutor {
    String getCommand();
    boolean execute(CommandSender sender, String[] args);
}
