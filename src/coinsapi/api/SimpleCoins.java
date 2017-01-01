package coinsapi.api;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.joris.plugin.main;

public class SimpleCoins {
	protected static HashMap<String, Integer> cache = new HashMap();
	public static Plugin plugin;
	  public static MySQL sql = new MySQL();
	  protected static String host = "localhost";
	  protected static Integer port = 3306;
	  protected static String user = "root";
	  protected static String password = "";
	  protected static String database = "PardoesCraft";
	  public static void startBackupLoop()
	  {
	    if ((Bukkit.getOfflinePlayers() != null) && (cache != null))
	    {
	      for(Player p: Bukkit.getOnlinePlayers()){
	    	  SimpleCoins.sql.setPlayerCoins(p, (Integer)SimpleCoins.cache.get(p.getUniqueId().toString()));
	 
	      }
	    }
	  }
	  
	  public static void clearCache()
	  {
	    if (cache != null)
	    {
	      for(Player p: Bukkit.getOnlinePlayers()){
	    	  SimpleCoins.sql.setPlayerCoins(p, (Integer)SimpleCoins.cache.remove(p.getUniqueId().toString()));
	 
	      }
	    }
	  }
}
