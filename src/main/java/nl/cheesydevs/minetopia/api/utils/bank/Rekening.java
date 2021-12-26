package nl.cheesydevs.minetopia.api.utils.bank;

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
    private double money;

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
    public void setMoney(double money) {
        this.money = money;
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
    public double getMoney() {
        return money;
    }
}
