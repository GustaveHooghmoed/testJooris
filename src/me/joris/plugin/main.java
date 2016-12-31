package me.joris.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	List<String> whitelisted = new ArrayList<String>();
	public void onEnable(){
		for(OfflinePlayer p : Bukkit.getWhitelistedPlayers()){

            whitelisted.add(p.getName());
        }
    System.out.println("Joris is cool");
    getCommand("testjoris").setExecutor(new testCommand());
    getServer().getPluginManager().registerEvents(new MyListener(), this);
	for(Player p : Bukkit.getServer().getOnlinePlayers()){
		if(p.isOp()){
			 p.sendMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is ingeschakeld!"));
			    Bukkit.setWhitelist(true);
			    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"§7Whitelist is ingeschakeld!"));
			    p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7Momentele Whitelist: " + whitelisted.toString()));
		}
    }
   


 }	
	
	public void onDisable(){
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',"§7Testcore is uitgeschakeld!"));
		
	}

}
