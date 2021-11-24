package nl.cheesydevs.minetopia.Utils;

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

    public static Version getVersion() {
        return version;
    }



}
