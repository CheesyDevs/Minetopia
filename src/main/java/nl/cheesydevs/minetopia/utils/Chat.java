package nl.cheesydevs.minetopia.utils;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Chat {
    private static final HashMap<Player, List<Placeholder>> placeholdersPlayers = new HashMap<>();

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String placeholders(String s, Player player) {
        refreshPlayerPlaceholders(player);
        for (Placeholder placeholder : placeholdersPlayers.get(player)) {
            s = s.replace(placeholder.getPlaceholder(), placeholder.getReplacement());
        }
        return s;
    }

    public static void refreshPlayerPlaceholders(Player player) {
        PlayerData playerData = Minetopia.getApi().getPlayerData().getPlayer(player);
        placeholdersPlayers.remove(player); // just to be safe
        List<Placeholder> placeholderList = new ArrayList<>();
        placeholderList.add(new Placeholder("<Money>", Minetopia.getApi().getPlayerData().getMoneyFormatted(player)));           // Money with vault
        placeholderList.add(new Placeholder("<Level>", playerData.getLevel()+""));                                    // Level
        placeholderList.add(new Placeholder("<Fitheid>", playerData.getFitheid()+""));                                // Fitheid
        placeholderList.add(new Placeholder("<Player>", player.getDisplayName()));                                              // Display name
        placeholderList.add(new Placeholder("<Name>", player.getName()));                                                       // Name
        placeholdersPlayers.put(player, placeholderList);
    }
}
