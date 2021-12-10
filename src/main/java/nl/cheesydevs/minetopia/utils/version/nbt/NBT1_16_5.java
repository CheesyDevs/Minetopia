package nl.cheesydevs.minetopia.utils.version.nbt;

import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.NBTTagString;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

@SuppressWarnings("Duplicates")
public class NBT1_16_5 {

    public static ItemStack set(ItemStack item, String tag, String definition) {
        net.minecraft.server.v1_16_R3.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = ((itemNMS).hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return item;
        NBTTag.set(tag, NBTTagString.a(definition));
        itemNMS.setTag(NBTTag);
        item = CraftItemStack.asBukkitCopy(itemNMS);
        return item;
    }

    public static String get(ItemStack item, String tag) {
        net.minecraft.server.v1_16_R3.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = (itemNMS.hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return null;
        return Objects.requireNonNull(NBTTag.get(tag)).toString().substring(1, Objects.requireNonNull(NBTTag.get(tag)).toString().length() - 1);
    }

}
