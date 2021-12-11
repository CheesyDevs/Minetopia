package nl.cheesydevs.minetopia.utils;

import org.bukkit.OfflinePlayer;

import java.util.List;

public class Job {
    String prefix;
    List<OfflinePlayer> players;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public void setPlayers(List<OfflinePlayer> players) {
        this.players = players;
    }

    public String getPrefix() {
        return prefix;
    }
    public List<OfflinePlayer> getPlayers() {
        return players;
    }
}
