package nl.cheesydevs.minetopia.modules.scoreboard;

import nl.cheesydevs.minetopia.Minetopia;
import nl.cheesydevs.minetopia.modules.MinetopiaModule;
import nl.cheesydevs.minetopia.modules.scoreboard.commands.ScoreboardCMD;
import nl.cheesydevs.minetopia.modules.scoreboard.utils.Scoreboard;
import nl.cheesydevs.minetopia.utils.version.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ScoreBoardModule extends MinetopiaModule {
    private int task;

    @Override
    public String name() {
        return "Scoreboard";
    }

    @Override
    public void onEnable() {
        Scoreboard.setup();
        registerCommands();
        int reducer = Minetopia.getApi().getSettings().getLagReducer();int speed;
        if(reducer == 0) {
            speed = 1;
        } else if(reducer == 1) {
            speed = 10;
        } else if(reducer == 2) {
            speed = 20;
        } else if(reducer == 3) {
            speed = 40;
        } else {
            speed = 5;
        }
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Minetopia.getInstance(), Scoreboard::update, 0, speed); // saving task id to cancel task on disable
        for (Player player : Bukkit.getOnlinePlayers()) {
            Scoreboard.add(player);
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTask(task);
        if(Scoreboard.getScoreboard() == null) return;
        for (Player player : Bukkit.getOnlinePlayers()) {
            Scoreboard.remove(player);
        }
    }

    private void registerCommands() {
        Command.register(new ScoreboardCMD("scoreboard"));
    }
}
