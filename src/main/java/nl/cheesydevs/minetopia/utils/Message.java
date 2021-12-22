package nl.cheesydevs.minetopia.utils;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.api.utils.Chat;

public class Message {

    public static void startupHeader() {
        Minetopia minetopia = Minetopia.getInstance();
        // not using \n because it's weird in console then
        minetopia.getLogger().info(Chat.color("&8---------- &3Minetopia &8----------"));
        minetopia.getLogger().info(Chat.color("&3Made with &c❤  &3by "+minetopia.getDescription().getAuthors().toString().substring(1, minetopia.getDescription().getAuthors().toString().length()-1)));
        minetopia.getLogger().info(Chat.color("&3Version: &b"+minetopia.getDescription().getVersion()));
    }

    public static void startupFooter() {
        Minetopia minetopia = Minetopia.getInstance();
        minetopia.getLogger().info(Chat.color("&8-------------------------------"));
    }

    public static void errorDependencyNotFound(String dependency) {
        Minetopia.getInstance().getLogger().severe("You don't have the dependency "+dependency+"! Please install "+dependency+" to use the plugin.");
    }

}
