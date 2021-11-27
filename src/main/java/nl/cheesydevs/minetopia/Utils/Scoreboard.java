package nl.cheesydevs.minetopia.Utils;

import nl.cheesydevs.minetopia.Utils.Files.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Scoreboard {

    private static org.bukkit.scoreboard.Scoreboard scoreboard;
    private static List<Player> enabled = new ArrayList<>();

    public static void setup() {
        List<String> scoreboardList = Config.getConfig().getStringList("Scoreboard");
        if(scoreboardList.isEmpty()) return;
        scoreboard = Objects.requireNonNull(Bukkit.getScoreboardManager()).getNewScoreboard();
        Objective obj = scoreboard.registerNewObjective("mtScoreboard", "dummy", Chat.color(scoreboardList.get(0)));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        for (int i = 0; i < scoreboardList.size(); i++) {
            if(i == 0) continue;
            Team team = scoreboard.registerNewTeam("mt"+i);
            team.addEntry(empty(i));
            obj.getScore(empty(i)).setScore(scoreboardList.size()-i);
        }
    }

    public static void update(Player p) {
        List<String> scoreboardList = Config.getConfig().getStringList("Scoreboard");
        if(scoreboardList.isEmpty()) return;
        for (int i = 0; i < scoreboardList.size(); i++) {
            if(i == 0) continue;
            Team team = getScoreboard().getTeam("mt"+i);
            if(team==null) return;
            team.setPrefix(Chat.color(Chat.placeholders(scoreboardList.get(i))));
        }
        p.setScoreboard(getScoreboard());
    }

    public static void update() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            update(p);
        }
    }

    public static void add(Player p) {
        enabled.add(p);
    }

    public static void remove(Player p) {
        enabled.remove(p);
    }

    public static String empty(int i) {
        List<ChatColor> colors = new ArrayList<>(Arrays.asList(ChatColor.values()));
        return colors.get(i).toString();
    }

    public static org.bukkit.scoreboard.Scoreboard getScoreboard() {
        return scoreboard;
    }
}
