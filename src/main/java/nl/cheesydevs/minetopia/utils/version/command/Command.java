package nl.cheesydevs.minetopia.utils.version.command;

import nl.cheesydevs.minetopia.utils.version.Version;
import nl.cheesydevs.minetopia.utils.version.VersionManager;
import org.bukkit.command.defaults.BukkitCommand;

public class Command {

    public static void register(BukkitCommand cmd) {
        if(VersionManager.getVersion().equals(Version.v1_12_2)) {Command1_12_2.register(cmd);}
        else if(VersionManager.getVersion().equals(Version.v1_13_2)) {Command1_13_2.register(cmd);}
        else if(VersionManager.getVersion().equals(Version.v1_14_4)) {Command1_14_4.register(cmd);}
        else if(VersionManager.getVersion().equals(Version.v1_15_2)) {Command1_15_2.register(cmd);}
        else if(VersionManager.getVersion().equals(Version.v1_16_5)) {Command1_16_5.register(cmd);}
        else if(VersionManager.getVersion().equals(Version.v1_17_1)) {Command1_17_1.register(cmd);}
        else {Command1_16_5.register(cmd);}
    }
}
