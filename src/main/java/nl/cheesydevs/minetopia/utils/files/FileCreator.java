package nl.cheesydevs.minetopia.utils.files;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static File createFile(String fileName) {
        File file = new File(Minetopia.getInstance().getDataFolder(), fileName);
        if(!file.exists()) {
            if(Minetopia.getInstance().getResource(fileName) != null) {
                Minetopia.getInstance().saveResource(fileName, false);
            } else {
                if(file.mkdirs()) return file;
            }
        }
        return file;
    }
    public static FileConfiguration createConfig(File file) {
        FileConfiguration fileConfig = new YamlConfiguration();
        try {
            fileConfig.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return fileConfig;
    }
}
