package nl.cheesydevs.minetopia.utils.version.nbt;

import nl.cheesydevs.minetopia.utils.version.Version;
import nl.cheesydevs.minetopia.utils.version.VersionManager;
import org.bukkit.inventory.ItemStack;

public class NBT {

    public static ItemStack set(ItemStack item, String tag, String definition) {
        if(VersionManager.getVersion().equals(Version.v1_12_2)) {return NBT1_12_2.set(item, tag, definition);}
        else if(VersionManager.getVersion().equals(Version.v1_13_2)) {return NBT1_13_2.set(item, tag, definition);}
        else if(VersionManager.getVersion().equals(Version.v1_14_4)) {return NBT1_14_4.set(item, tag, definition);}
        else if(VersionManager.getVersion().equals(Version.v1_15_2)) {return NBT1_15_2.set(item, tag, definition);}
        else if(VersionManager.getVersion().equals(Version.v1_16_5)) {return NBT1_16_5.set(item, tag, definition);}
        else if(VersionManager.getVersion().equals(Version.v1_17_1)) {return NBT1_17_1.set(item, tag, definition);}
        else {return NBT1_16_5.set(item, tag, definition);}
    }

    public static String get(ItemStack item, String tag) {
        if(VersionManager.getVersion().equals(Version.v1_12_2)) {return NBT1_12_2.get(item, tag);}
        else if(VersionManager.getVersion().equals(Version.v1_13_2)) {return NBT1_13_2.get(item, tag);}
        else if(VersionManager.getVersion().equals(Version.v1_14_4)) {return NBT1_14_4.get(item, tag);}
        else if(VersionManager.getVersion().equals(Version.v1_15_2)) {return NBT1_15_2.get(item, tag);}
        else if(VersionManager.getVersion().equals(Version.v1_16_5)) {return NBT1_16_5.get(item, tag);}
        else if(VersionManager.getVersion().equals(Version.v1_17_1)) {return NBT1_17_1.get(item, tag);}
        else {return NBT1_16_5.get(item, tag);}
    }

}
