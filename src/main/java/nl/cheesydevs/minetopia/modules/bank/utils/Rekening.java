package nl.cheesydevs.minetopia.modules.bank.utils;

import nl.cheesydevs.minetopia.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.Config;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private RekeningType rekeningType;
    private int rekeningID;
    private String name = Config.getConfig().getString("DefaultRekeningName");
    private OfflinePlayer owner;
    private List<OfflinePlayer> players = new ArrayList<>();

    public void setRekeningType(RekeningType rekeningType) {
        this.rekeningType = rekeningType;
    }
    public void setRekeningID(int rekeningID) {
        this.rekeningID = rekeningID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setOwner(OfflinePlayer owner) {
        this.owner = owner;
    }
    public void setPlayers(List<OfflinePlayer> players) {
        this.players = players;
    }

    public RekeningType getRekeningType() {
        return rekeningType;
    }
    public int getRekeningID() {
        return rekeningID;
    }
    public String getName() {
        return name;
    }
    public OfflinePlayer getOwner() {
        return owner;
    }
    public List<OfflinePlayer> getPlayers() {
        return players;
    }
}
