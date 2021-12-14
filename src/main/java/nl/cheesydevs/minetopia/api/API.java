package nl.cheesydevs.minetopia.api;

public class API {
    private static PlayerDataAPI playerData;
    private static BankingAPI banking;
    private static SettingsAPI settings;
    public PlayerDataAPI getPlayerData() {
        return playerData;
    }
    public BankingAPI getBanking() {
        return banking;
    }
    public SettingsAPI getSettings() {
        return settings;
    }

    /**
     * DO NOT USE THIS!
     */
    public static void setup() {
        playerData = new PlayerDataAPI();
        banking = new BankingAPI();
        settings = new SettingsAPI();
    }
}
