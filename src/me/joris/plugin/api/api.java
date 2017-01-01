package me.joris.plugin.api;

import org.bukkit.event.Listener;

public class api implements Listener {
	
	public static boolean web = false;
	public static void registerWebPanel(){
		web = true;
	}
}
