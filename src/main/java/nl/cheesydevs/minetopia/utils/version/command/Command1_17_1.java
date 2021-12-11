package nl.cheesydevs.minetopia.utils.version.command;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;

public class Command1_17_1 {

    public static void register(BukkitCommand cmd) {
        CraftServer craftServer = (CraftServer)Minetopia.getInstance().getServer();
        craftServer.getCommandMap().register(Minetopia.getInstance().getName(), cmd);
    }

}
