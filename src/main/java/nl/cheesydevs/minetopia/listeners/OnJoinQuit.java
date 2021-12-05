package nl.cheesydevs.minetopia.listeners;

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
        e.setJoinMessage(Objects.requireNonNull(Config.getConfig().getString("JoinMessage")).replace("<Player>", e.getPlayer().getName()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Scoreboard.remove(e.getPlayer());
        e.setQuitMessage(Objects.requireNonNull(Config.getConfig().getString("LeaveMessage")).replace("<Player>", e.getPlayer().getName()));
    }

}
