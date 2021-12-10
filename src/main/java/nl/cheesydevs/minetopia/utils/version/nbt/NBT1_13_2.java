package nl.cheesydevs.minetopia.utils.version.nbt;

import net.minecraft.server.v1_13_R2.NBTTagCompound;
import net.minecraft.server.v1_13_R2.NBTTagString;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("Duplicates")
public class NBT1_13_2 {

    public static ItemStack set(ItemStack item, String tag, String definition) {
        net.minecraft.server.v1_13_R2.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = ((itemNMS).hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return item;
        NBTTag.set(tag, new NBTTagString(definition));
        itemNMS.setTag(NBTTag);
        item = CraftItemStack.asBukkitCopy(itemNMS);
        return item;
    }

    public static String get(ItemStack item, String tag) {
        net.minecraft.server.v1_13_R2.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = (itemNMS.hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return null;
        return NBTTag.get(tag).toString().substring(1, NBTTag.get(tag).toString().length() - 1);
    }

}
