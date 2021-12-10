package nl.cheesydevs.minetopia.utils.files;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static File createFile(String filename) {
        File file = new File(Minetopia.getInstance().getDataFolder(), filename);
        if(!file.exists()) {
            if(Minetopia.getInstance().getResource(filename) != null) {
                Minetopia.getInstance().saveResource(filename, false);
            } else {
                try {
                    if(file.createNewFile()) return file;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
    public static File createFile(String path, String filename) {
        File folder = new File(Minetopia.getInstance().getDataFolder()+path);
        File file = new File(folder, filename);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        if(!file.exists()) {
            try {
                if(file.createNewFile()) return file;
            } catch (IOException e) {
                e.printStackTrace();
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
