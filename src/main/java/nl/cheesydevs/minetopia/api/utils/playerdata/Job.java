package nl.cheesydevs.minetopia.api.utils.playerdata;

import org.bukkit.OfflinePlayer;

import java.util.List;

@SuppressWarnings("unused")
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
