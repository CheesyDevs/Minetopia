package nl.cheesydevs.minetopia.api;

public class API {
    private static PlayerDataAPI playerData;
    private static BankingAPI banking;
    public PlayerDataAPI getPlayerData() {
        return playerData;
    }
    public BankingAPI getBanking() {
        return banking;
    }

    /**
     * DO NOT USE THIS!
     */
    public static void setup() {
        playerData = new PlayerDataAPI();
        banking = new BankingAPI();
    }
}
