package nl.cheesydevs.minetopia.api;

import nl.cheesydevs.minetopia.utils.Job;
import nl.cheesydevs.minetopia.utils.PlayerData;
import nl.cheesydevs.minetopia.utils.Vault;
import nl.cheesydevs.minetopia.utils.files.PlayerDataFiles;
import org.bukkit.OfflinePlayer;

public class PlayerDataAPI {

    public PlayerData getPlayer(OfflinePlayer offlinePlayer) {
        return new PlayerData(null, // null because it's not implemented yet.
                PlayerDataFiles.getPlayerConfig().getInt(offlinePlayer.getUniqueId()+".Level"),
                PlayerDataFiles.getPlayerConfig().getInt(offlinePlayer.getUniqueId()+".Fitheid")
        );
    }

    public void setJob(OfflinePlayer offlinePlayer, Job job) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setJob(job);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    public void setLevel(OfflinePlayer offlinePlayer, int level) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setLevel(level);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    public void setFitheid(OfflinePlayer offlinePlayer, int fitheid) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setFitheid(fitheid);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    public String getMoneyFormatted(OfflinePlayer offlinePlayer) {
        return Vault.getBalanceFormatted(offlinePlayer);
    }

    public double getMoney(OfflinePlayer offlinePlayer) {
        return Vault.getEconomy().getBalance(offlinePlayer);
    }

}
