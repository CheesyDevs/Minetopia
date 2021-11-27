package nl.cheesydevs.minetopia.Utils;

import nl.cheesydevs.minetopia.Minetopia;

public class Message {

    public static void errorDependencyNotFound(String dependency) {
        Minetopia.getInstance().getLogger().severe("You don't have the dependency "+dependency+"! Please install "+dependency+" to use the plugin.");
    }

}
