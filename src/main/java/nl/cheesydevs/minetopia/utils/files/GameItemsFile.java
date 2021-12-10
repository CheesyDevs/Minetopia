package nl.cheesydevs.minetopia.utils.files;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

@SuppressWarnings("SpellCheckingInspection")
public class GameItemsFile {

    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        file = FileCreator.createFile("gameitems.yml");
        config = FileCreator.createConfig(file);
    }

    public static File getFile() {
        return file;
    }
    public static FileConfiguration getConfig() {
        return config;
    }
}
