package me.joris.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class MyScoreboard implements Listener {


public static void setScoreboard(){
	for (Player p : Bukkit.getOnlinePlayers()) {
	      ScoreboardManager sbManager = Bukkit.getScoreboardManager();
	      Scoreboard sBoard = sbManager.getNewScoreboard();
	      int onlinePlayers1 = Integer.valueOf(Bukkit.getOnlinePlayers().size()).intValue();
	      int totalPlayers = Bukkit.getOfflinePlayers().length;
	      Objective sidebar = sBoard.registerNewObjective("main", "dummy");
	      sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
	      sidebar.setDisplayName("  §4§l PardoesCraft  ");
	      Score onps = sidebar.getScore("§7Online Spelers");
	      Score totps = sidebar.getScore("§7Unieke Spelers");

	      onps.setScore(onlinePlayers1);
	      totps.setScore(totalPlayers);
	      p.setScoreboard(sBoard);
      }
   }

public static void setScoreboardforName(){
    for (Player p : Bukkit.getOnlinePlayers()) {
        if(p.isOp()){
          ScoreboardManager sbManager = Bukkit.getScoreboardManager();
          Scoreboard sBoard = sbManager.getNewScoreboard();
          Objective sidebar = sBoard.registerNewObjective("main", "dummy");
          sidebar.setDisplaySlot(DisplaySlot.BELOW_NAME);
          sidebar.setDisplayName(ChatColor.AQUA + "Staff");
          p.setScoreboard(sBoard);
      } else {
          ScoreboardManager sbManager = Bukkit.getScoreboardManager();
          Scoreboard sBoard = sbManager.getNewScoreboard();
          Objective sidebar = sBoard.registerNewObjective("main", "dummy");
          sidebar.setDisplaySlot(DisplaySlot.BELOW_NAME);
          sidebar.setDisplayName(ChatColor.WHITE + "Bezoeker");
          p.setScoreboard(sBoard);
      }
   }
}
    public static void setScoreboardPlayer(Player p2){
              ScoreboardManager sbManager = Bukkit.getScoreboardManager();
              Scoreboard sBoard = sbManager.getNewScoreboard();
              int onlinePlayers1 = Integer.valueOf(Bukkit.getOnlinePlayers().size()).intValue();
              int totalPlayers = Bukkit.getOfflinePlayers().length;
              Objective sidebar = sBoard.registerNewObjective("main", "dummy");
              sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
              sidebar.setDisplayName("  §4§l PardoesCraft  ");
              Score onps = sidebar.getScore("§7Online Spelers");
              Score totps = sidebar.getScore("§7Unieke Spelers");

              onps.setScore(onlinePlayers1);
              totps.setScore(totalPlayers);
              p2.setScoreboard(sBoard);
        for (Player p : Bukkit.getOnlinePlayers()) {
            if(p.isOp()){
              sidebar.setDisplaySlot(DisplaySlot.BELOW_NAME);
              sidebar.setDisplayName(ChatColor.AQUA + "Staff");
              p2.setScoreboard(sBoard);
          } else {
              sidebar.setDisplaySlot(DisplaySlot.BELOW_NAME);
              sidebar.setDisplayName(ChatColor.WHITE + "Bezoeker");
              p2.setScoreboard(sBoard);
          }
       }
    }
}
