package me.joris.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.joris.plugin.api.api;

public class main extends JavaPlugin {
	static Plugin pl = null;
	List<String> whitelisted = new ArrayList<String>();
	public void onEnable(){
		for(OfflinePlayer p : Bukkit.getWhitelistedPlayers()){

            whitelisted.add(p.getName());
        }
		pl = this;
		getServer().getPluginManager().registerEvents(new api(), this);
    System.out.println("Joris is cool");
    getCommand("testjoris").setExecutor(new testCommand());
    getServer().getPluginManager().registerEvents(new MyListener(), this);
    MyScoreboard.setScoreboard();
    MyScoreboard.setScoreboardforName();
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is ingeschakeld!!"));
    Bukkit.setWhitelist(true);
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Whitelist is ingeschakeld!!"));
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Momentele Whitelist: " + whitelisted.toString()));


 }	
	
	public void onDisable(){
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is uitgeschakeld!"));
		
	}

	public static Plugin getInstance() {
		return pl;
	}

}
