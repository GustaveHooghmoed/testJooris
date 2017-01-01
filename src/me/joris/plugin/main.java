package me.joris.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import coinsapi.api.SimpleCoins;
import net.milkbowl.vault.economy.Economy;

public class main extends JavaPlugin {
	static Plugin pl = null;
	List<String> whitelisted = new ArrayList<String>();
	public void onEnable(){
		for(OfflinePlayer p : Bukkit.getWhitelistedPlayers()){

            whitelisted.add(p.getName());
        }
		pl = this;
    System.out.println("Joris is cool");
    getCommand("testjoris").setExecutor(new testCommand());
    getServer().getPluginManager().registerEvents(new MyListener(), this);
    MyScoreboard.setScoreboard();
    MyScoreboard.setScoreboardforName();
    
    // MICHEL METHODES
    registerEconomy();
    new BukkitRunnable()
    {
      public void run()
      {
        SimpleCoins.sql.openConnection();
        SimpleCoins.sql.createTables();
        SimpleCoins.startBackupLoop();
      }
    }.runTaskAsynchronously(this);
    
    getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
        SimpleCoins.clearCache();
      }
    }, 200L, 6000L);

 }	
	private void registerEconomy()
	  {
	    if (getServer().getPluginManager().getPlugin("Vault") != null)
	    {
	      ServicesManager sm = getServer().getServicesManager();
	      sm.register(Economy.class, new Economy_SimpleCoins(), this, ServicePriority.Highest);
	      System.out.println("[SC-API] Registered Vault interface.");
	    }
	    else
	    {
	      System.out.println("[SC-API] Vault not found.");
	    }
	  }
	
	public void onDisable(){
	
		
	}

	public static Plugin getInstance() {
		return pl;
	}

}
