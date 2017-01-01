package me.joris.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import coinsapi.api.methodsAPI;

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
    getCommand("aspc").setExecutor(new me.joris.plugin.armorstands.testCommand());
    getServer().getPluginManager().registerEvents(new MyListener(), this);
    MyScoreboard.setScoreboard();
    MyScoreboard.setScoreboardforName();
    
    // MICHEL METHODES
    for(Player p : Bukkit.getOnlinePlayers()){
    	registerEconomy(p);
    }
    getServer().getPluginManager().registerEvents(new me.joris.plugin.armorstands.MyListener(), this);

 }	
	private void registerEconomy(Player player){
		methodsAPI eco = new methodsAPI(player.getUniqueId(), player);
		eco.createPlayerConfig();
		}
	
	public void onDisable(){
	
		
	}

	public static Plugin getInstance() {
		return pl;
	}

}
