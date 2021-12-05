package nl.cheesydevs.minetopia.utils;

import org.bukkit.ChatColor;

import java.util.HashMap;

public class Chat {
    private static final HashMap<String, String> placeholders = new HashMap<>();

    public static void setupPlaceholders() {
        placeholders.put("<emptyLine>", " ");
    }

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String placeholders(String s) {
        for (String holder : getPlaceholders().keySet()) {
            s = s.replace(holder, getPlaceholders().get(holder));
        }
        return s;
    }

    public static HashMap<String, String> getPlaceholders() {
        return placeholders;
    }
}
