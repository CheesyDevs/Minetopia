package nl.cheesydevs.minetopia.utils;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;

public class VersionManager {

    private static Version version = Version.unknown; // default is unknown

    public static void setup() {
        String serverVersion = Minetopia.getInstance().getServer().getVersion();
        for (Version ver : Version.values()) {
            if(serverVersion.contains(ver.toString())) {
                version = ver;
            }
        }
        Minetopia.getInstance().getLogger().info("Server running on version "+getVersion().toString());
    }

    public static CraftServer getServer() {
        return (CraftServer) Minetopia.getInstance().getServer();
    }

    public static Version getVersion() {
        return version;
    }



}
