package nl.cheesydevs.minetopia.Utils.Files;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class Config {

    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        file = new File(Minetopia.getInstance().getDataFolder(), "config.yml");
        Minetopia.getInstance().saveDefaultConfig();
        config = Minetopia.getInstance().getConfig();
    }

    public static void reload() {
        Minetopia.getInstance().reloadConfig();
    }

    public static File getFile() {
        return file;
    }
    public static FileConfiguration getConfig() {
        return config;
    }
}
