package me.joris.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public void onEnable(){
	   System.out.println("Joris is cool");
	   getCommand("testjoris").setExecutor(new testCommand());
	}
	
	public void onDisable(){
		
	}

}
