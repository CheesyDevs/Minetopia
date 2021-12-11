package nl.cheesydevs.minetopia.api;

import nl.cheesydevs.minetopia.utils.Job;
import nl.cheesydevs.minetopia.utils.PlayerData;
import nl.cheesydevs.minetopia.utils.Vault;
import nl.cheesydevs.minetopia.utils.files.PlayerDataFiles;
import org.bukkit.OfflinePlayer;

@SuppressWarnings("unused")
public class PlayerDataAPI {

    /**
     * Get the PlayerData from a player
     * @param offlinePlayer the player you want the PlayerData from
     * @return the PlayerData
     */
    public PlayerData getPlayer(OfflinePlayer offlinePlayer) {
        return new PlayerData(null, // null because it's not implemented yet.
                PlayerDataFiles.getPlayerConfig().getInt(offlinePlayer.getUniqueId()+".Level"),
                PlayerDataFiles.getPlayerConfig().getInt(offlinePlayer.getUniqueId()+".Fitheid")
        );
    }

    /**
     * Set the job of a player
     * @param offlinePlayer the player you want to set the job
     * @param job the job you want to set
     */
    public void setJob(OfflinePlayer offlinePlayer, Job job) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setJob(job);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    /**
     * Set the level of a player
     * @param offlinePlayer the player you want to set the level
     * @param level the level you want to set
     */
    public void setLevel(OfflinePlayer offlinePlayer, int level) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setLevel(level);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    /**
     * Set the fitheid of a player
     * @param offlinePlayer the player you want to set the fitheid
     * @param fitheid the fitheid you want to set
     */
    public void setFitheid(OfflinePlayer offlinePlayer, int fitheid) {
        PlayerData playerData = getPlayer(offlinePlayer);playerData.setFitheid(fitheid);
        PlayerDataFiles.savePlayerData(playerData, offlinePlayer);
    }

    /**
     * Get the money of a player formatted in a string
     * @param offlinePlayer the player you want to get the money from
     * @return the player money formatted
     */
    public String getMoneyFormatted(OfflinePlayer offlinePlayer) {
        return Vault.getBalanceFormatted(offlinePlayer);
    }

    /**
     * Get the money of a player
     * @param offlinePlayer the player you want to get the money from
     * @return the player money
     */
    public double getMoney(OfflinePlayer offlinePlayer) {
        return Vault.getEconomy().getBalance(offlinePlayer);
    }

}
