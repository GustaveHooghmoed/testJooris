package me.joris.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import coinsapi.api.methodsAPI;

public class MyListener implements Listener {
	
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("Welcome to the server!");
        Player p = event.getPlayer();
        MyScoreboard.setScoreboardPlayer(p);
        new BukkitRunnable()
        {
          public void run()
          {
        	  methodsAPI eco = new methodsAPI(p.getUniqueId(),p);
      		eco.createPlayerConfig();
          }
        }.runTaskAsynchronously(main.getInstance());
    }
}
