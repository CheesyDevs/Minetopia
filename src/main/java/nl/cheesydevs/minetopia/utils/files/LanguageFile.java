package nl.cheesydevs.minetopia.utils.files;

import nl.cheesydevs.minetopia.utils.Chat;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.*;

@SuppressWarnings("SpellCheckingInspection")
public class LanguageFile {

    private static FileConfiguration config;

    public static void setup() {
        String filename = "language.yml";
        File file = FileCreator.createFile(filename);
        config = FileCreator.createConfig(file);
        config.setDefaults(FileCreator.getDefault(filename));
        config.options().copyDefaults(true);
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String path) {
        if(config.getString(path) == null) return Chat.color("&cnot found");
        return Chat.color(config.getString(path));
    }
}
