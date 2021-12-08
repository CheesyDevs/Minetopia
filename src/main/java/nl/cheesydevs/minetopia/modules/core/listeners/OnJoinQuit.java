package nl.cheesydevs.minetopia.modules.core.listeners;

import nl.cheesydevs.minetopia.utils.Chat;
import nl.cheesydevs.minetopia.utils.files.Config;
import nl.cheesydevs.minetopia.utils.Scoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class OnJoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Scoreboard.add(e.getPlayer());
        e.setJoinMessage(Chat.color(Objects.requireNonNull(Config.getConfig().getString("JoinMessage")).replace("<Name>", e.getPlayer().getName())));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Scoreboard.remove(e.getPlayer());
        e.setQuitMessage(Chat.color(Objects.requireNonNull(Config.getConfig().getString("LeaveMessage")).replace("<Name>", e.getPlayer().getName())));
    }

}
