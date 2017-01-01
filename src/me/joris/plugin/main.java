package me.joris.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.joris.plugin.api.api;
import me.joris.plugin.api.data;
import me.joris.plugin.api.socket.WebsocketServer;

public class main extends JavaPlugin {
	static Plugin pl = null;
	List<String> whitelisted = new ArrayList<String>();
	public void onEnable(){
		for(OfflinePlayer p : Bukkit.getWhitelistedPlayers()){

            whitelisted.add(p.getName());
        }
		pl = this;
		getServer().getPluginManager().registerEvents(new api(), this);
		api.registerWebPanel();
    System.out.println("Joris is cool");
    getCommand("testjoris").setExecutor(new testCommand());
    getCommand("data").setExecutor(new data());
    getServer().getPluginManager().registerEvents(new MyListener(), this);
    MyScoreboard.setScoreboard();
    MyScoreboard.setScoreboardforName();
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is ingeschakeld!!"));
    Bukkit.setWhitelist(true);
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Whitelist is ingeschakeld!!"));
    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"Momentele Whitelist: " + whitelisted.toString()));
    try {
		WebsocketServer.runServer();
	} catch (InterruptedException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 }	
	
	public void onDisable(){
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is uitgeschakeld!"));
		
	}

	public static Plugin getInstance() {
		return pl;
	}

}
