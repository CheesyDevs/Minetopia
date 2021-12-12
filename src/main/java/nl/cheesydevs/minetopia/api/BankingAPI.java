package nl.cheesydevs.minetopia.api;

import nl.cheesydevs.minetopia.modules.bank.utils.Rekening;
import nl.cheesydevs.minetopia.modules.bank.utils.RekeningType;
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
     * Get a rekening from id
     * @param id the id of the rekening
     * @return the Rekening
     */
    public Rekening getRekening(int id) {
        Rekening rekening = new Rekening();
        rekening.setRekeningID(id);
        rekening.setRekeningType(RekeningType.valueOf(PlayerDataFiles.getBankingConfig().getString(id+".RekeningType")));
        rekening.setOwner(Bukkit.getOfflinePlayer(UUID.fromString(Objects.requireNonNull(PlayerDataFiles.getBankingConfig().getString(id + ".Owner")))));
        List<OfflinePlayer> players = new ArrayList<>();
        for (String uuid : Objects.requireNonNull(PlayerDataFiles.getBankingConfig().getStringList(id + ".Players"))) {
            players.add(Bukkit.getOfflinePlayer(UUID.fromString(uuid)));
        }
        rekening.setPlayers(players);
        return rekening;
    }
}
