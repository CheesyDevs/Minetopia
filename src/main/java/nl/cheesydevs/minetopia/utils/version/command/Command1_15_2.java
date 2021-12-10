package nl.cheesydevs.minetopia.utils.version.command;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;

public class Command1_15_2 {

    public static void register(BukkitCommand cmd) {
        CraftServer craftServer = (CraftServer)Minetopia.getInstance().getServer();
        craftServer.getCommandMap().register(cmd.getName(), cmd);
    }

}
