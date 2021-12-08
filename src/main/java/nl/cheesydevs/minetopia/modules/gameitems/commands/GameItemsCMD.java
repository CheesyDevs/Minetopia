package nl.cheesydevs.minetopia.modules.gameitems.commands;

import nl.cheesydevs.minetopia.modules.gameitems.utils.GameItemsMainGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Objects;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsCMD extends BukkitCommand {

    public GameItemsCMD(String name) {
        super(name);
        setDescription("Get TexturePack items from gameitems.yml");
        setPermission("minetopia.gameitems");
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender, @Nonnull String label, @Nonnull String[] args) {
        if(!(sender instanceof Player)) return false;
        if(!sender.hasPermission(Objects.requireNonNull(getPermission()))) return false;
        Player p = (Player) sender;
        p.openInventory(GameItemsMainGUI.getInventory());
        return true;
    }
}
