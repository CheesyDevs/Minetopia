package nl.cheesydevs.minetopia.utils.files;

import nl.cheesydevs.minetopia.Minetopia;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class PlayerDataFiles {
    private static File playerFile;
    private static FileConfiguration playerConfig;

    public static void setup() {
        playerFile = FileCreator.createFile("/playerdata/", "data.yml");
        playerConfig = FileCreator.createConfig(playerFile);
    }

    public static void setupPlayer(Player player) {
        if(getPlayerConfig().get(player.getName()) == null) {
            setupPlayer(player, true);
        } else {
            Minetopia.getInstance().getLogger().severe("Not replacing playerdata for "+player.getName()+"... Add a replace statement.");
        }
    }

    public static void setupPlayer(Player player, boolean replace) {
        if(replace) {
            getPlayerConfig().set(player.getName() + ".Level", 0);
            getPlayerConfig().set(player.getName() + ".Fitheid", 0);
            savePlayerFile();
        } else {
            Minetopia.getInstance().getLogger().severe("Not replacing playerdata for "+player.getName()+"... Change the replace statement to true.");
        }
    }

    public static void savePlayerFile() {
        try {
            getPlayerConfig().save(getPlayerFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static File getPlayerFile() {
        return playerFile;
    }
    public static FileConfiguration getPlayerConfig() {
        return playerConfig;
    }
}
