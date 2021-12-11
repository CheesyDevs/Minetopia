package nl.cheesydevs.minetopia.api;

public class API {
    private static PlayerDataAPI playerData;
    public PlayerDataAPI getPlayerData() {
        return playerData;
    }

    /**
     * DO NOT USE THIS!
     */
    public static void setup() {
        playerData = new PlayerDataAPI();
    }
}
