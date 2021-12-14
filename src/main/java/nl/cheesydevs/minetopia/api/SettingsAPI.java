package nl.cheesydevs.minetopia.api;

import nl.cheesydevs.minetopia.utils.files.Config;

import java.io.IOException;

public class SettingsAPI {

    /**
     * Get debug from config.yml
     * @return debug setting from config.yml
     */
    public boolean getDebug() {
        return Config.getConfig().getBoolean("Debug");
    }

    /**
     * Get LagReducer if you want te add it into a module
     * @apiNote Can only be 0-3 (will change automatically if not that)
     * @return LagReducer setting from config.yml
     */
    public int getLagReducer() {
        if (Config.getConfig().getInt("LagReducer") > 3) {
            Config.getConfig().set("LagReducer", 3);try{Config.getConfig().save(Config.getFile());}catch(IOException e){e.printStackTrace();}
        }
        if(Config.getConfig().getInt("LagReducer") < 0) {
            Config.getConfig().set("LagReducer", 0);try{Config.getConfig().save(Config.getFile());}catch(IOException e){e.printStackTrace();}
        }
        return Config.getConfig().getInt("LagReducer");
    }

}
