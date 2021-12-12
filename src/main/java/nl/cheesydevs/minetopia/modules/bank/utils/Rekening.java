package nl.cheesydevs.minetopia.modules.bank.utils;

import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class Rekening {
    private RekeningType rekeningType;
    private int rekeningID;
    private OfflinePlayer owner;
    private List<OfflinePlayer> players = new ArrayList<>();

    public void setRekeningType(RekeningType rekeningType) {
        this.rekeningType = rekeningType;
    }
    public void setRekeningID(int rekeningID) {
        this.rekeningID = rekeningID;
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
    public OfflinePlayer getOwner() {
        return owner;
    }
    public List<OfflinePlayer> getPlayers() {
        return players;
    }
}
