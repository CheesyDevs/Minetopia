package nl.cheesydevs.minetopia.utils.command;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;

public class Command1_16_5 {

    public static void register(BukkitCommand cmd) {
        CraftServer craftServer = (CraftServer) Minetopia.getInstance().getServer();
        craftServer.getCommandMap().register(cmd.getName(), cmd);
    }

}
