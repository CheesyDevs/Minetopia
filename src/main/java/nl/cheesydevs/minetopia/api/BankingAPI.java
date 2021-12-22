package nl.cheesydevs.minetopia.api;

import nl.cheesydevs.minetopia.api.utils.bank.Rekening;
import nl.cheesydevs.minetopia.api.utils.bank.RekeningType;
import nl.cheesydevs.minetopia.api.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.PlayerDataFiles;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@SuppressWarnings("unused")
public class BankingAPI {

    /**
     * Make a new rekening
     * @param rekeningType the type of the rekening
     * @param owner the owner of the rekening
     * @param players sub members of the rekening
     * @apiNote this also saves to banking.yml
     */
    public void makeRekening(RekeningType rekeningType, OfflinePlayer owner, List<OfflinePlayer> players) {
        Rekening rekening = new Rekening();
        rekening.setRekeningID(PlayerDataFiles.getBankingConfig().getInt("id"));
        rekening.setRekeningType(rekeningType);
        rekening.setOwner(owner);
        rekening.setPlayers(players);
        PlayerDataFiles.getBankingConfig().set("id", PlayerDataFiles.getBankingConfig().getInt("id")+1);
        PlayerDataFiles.saveRekening(rekening);
    }

    /**
     * Make a new rekening
     * @param rekeningType the type of the rekening
     * @param owner the owner of the rekening
     * @param players sub members of the rekening
     * @param name the displayname of the rekening
     * @apiNote this also saves to banking.yml
     */
    public void makeRekening(RekeningType rekeningType, OfflinePlayer owner, List<OfflinePlayer> players, String name) {
        Rekening rekening = new Rekening();
        rekening.setRekeningID(PlayerDataFiles.getBankingConfig().getInt("id"));
        rekening.setRekeningType(rekeningType);
        rekening.setOwner(owner);
        rekening.setPlayers(players);
        rekening.setName(Chat.color(name));
        PlayerDataFiles.getBankingConfig().set("id", PlayerDataFiles.getBankingConfig().getInt("id")+1);
        PlayerDataFiles.saveRekening(rekening);
    }

    /**
     * Get a rekening from id
     * @param id the id of the rekening
     * @return the Rekening
     */
    public Rekening getRekening(int id) {
        Rekening rekening = new Rekening();
        rekening.setRekeningID(id);
        rekening.setRekeningType(RekeningType.valueOf(PlayerDataFiles.getBankingConfig().getString(id+".RekeningType")));
        rekening.setName(PlayerDataFiles.getBankingConfig().getString(id+".Name"));
        rekening.setOwner(Bukkit.getOfflinePlayer(UUID.fromString(Objects.requireNonNull(PlayerDataFiles.getBankingConfig().getString(id+".Owner")))));
        List<OfflinePlayer> players = new ArrayList<>();
        for (String uuid : Objects.requireNonNull(PlayerDataFiles.getBankingConfig().getStringList(id+".Players"))) {
            players.add(Bukkit.getOfflinePlayer(UUID.fromString(uuid)));
        }
        rekening.setPlayers(players);
        return rekening;
    }

    /**
     * Get all rekeningen of player
     * @param player the player you want the rekening from
     * @return the rekeningen
     */
    public List<Rekening> getPlayerRekening(OfflinePlayer player) {
        List<Rekening> rekeningen = new ArrayList<>();
        for (Rekening rekening : getRekeningList()) {
            if(rekening.getPlayers().contains(player)) {
                rekeningen.add(rekening);
            }
        }
        return rekeningen;
    }

    /**
     * Get all the rekeningen from banking.yml
     * @return the all the rekeningen
     */
    public List<Rekening> getRekeningList() {
        List<Rekening> rekening = new ArrayList<>();
        for (String id : PlayerDataFiles.getBankingConfig().getKeys(false)) {
            if(id.equals("id")) continue;
            rekening.add(getRekening(Integer.parseInt(id)));
        }
        return rekening;
    }

    /**
     * Get last rekeningen id from banking.yml
     * @return the rekening id
     */
    public int getLastRekeningId() {
        return PlayerDataFiles.getBankingConfig().getInt("id")-1;
    }
}
