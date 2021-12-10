package nl.cheesydevs.minetopia.utils.version.nbt;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

@SuppressWarnings("Duplicates")
public class NBT1_17_1 {

    public static ItemStack set(ItemStack item, String tag, String definition) {
        net.minecraft.world.item.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = ((itemNMS).hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return item;
        NBTTag.set(tag, NBTTagString.a(definition));
        itemNMS.setTag(NBTTag);
        item = CraftItemStack.asBukkitCopy(itemNMS);
        return item;
    }

    public static String get(ItemStack item, String tag) {
        net.minecraft.world.item.ItemStack itemNMS = CraftItemStack.asNMSCopy(item);
        NBTTagCompound NBTTag = (itemNMS.hasTag()) ? itemNMS.getTag() : new NBTTagCompound();
        if(NBTTag == null) return null;
        return Objects.requireNonNull(NBTTag.get(tag)).toString().substring(1, Objects.requireNonNull(NBTTag.get(tag)).toString().length() - 1);
    }

}
