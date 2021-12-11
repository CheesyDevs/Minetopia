package nl.cheesydevs.minetopia.modules.scoreboard;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.scoreboard.commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.modules.scoreboard.utils.Scoreboard;
import nl.cheesydevs.minetopia.utils.files.Config;
import nl.cheesydevs.minetopia.utils.version.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreBoardModule extends MinetopiaModule {

    @Override
    public String name() {
        return "Scoreboard";
    }

    @Override
    public void onEnable() {
        Scoreboard.setup();
        registerCommands();
        int speed = 1;if(Config.getConfig().getBoolean("LagReducer")) speed = 10;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Minetopia.getInstance(), Scoreboard::update, 0, speed);
        for (Player player : Bukkit.getOnlinePlayers()) {
            Scoreboard.add(player);
        }
    }

    @Override
    public void onDisable() {
        if(Scoreboard.getScoreboard() == null) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            Scoreboard.remove(player);
        }
    }

    private void registerCommands() {
        Command.register(new ScoreboardCMD("scoreboard"));
    }
}
