package nl.cheesydevs.minetopia.utils;

import nl.cheesydevs.minetopia.Minetopia;

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

    public static org.bukkit.craftbukkit.v1_12_R1.CraftServer getServer() {
        if(version.equals(Version.v1_12_2)) return (org.bukkit.craftbukkit.v1_12_R1.CraftServer)Minetopia.getInstance().getServer();
        if(version.equals(Version.v1_16)) return (org.bukkit.craftbukkit.)
        return null;
    }

    public static Version getVersion() {
        return version;
    }



}
