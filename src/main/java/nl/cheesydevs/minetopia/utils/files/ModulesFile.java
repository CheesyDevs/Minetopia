package nl.cheesydevs.minetopia.utils.files;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class ModulesFile {
    private static File file;
    private static FileConfiguration config;

    public static void setup() {
        file = FileCreator.createFile("modules.yml");
        config = FileCreator.createConfig(file);
    }

    public static void reload() {
        config = FileCreator.createConfig(file);
    }

    public static void save() {
        try {
            getConfig().save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File getFile() {
        return file;
    }
    public static FileConfiguration getConfig() {
        return config;
    }
}
