package me.joris.plugin.armorstands;

import java.io.IOException;

import org.bloxy.costumes.main.Costume;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import coinsapi.api.methodsAPI;

public class testCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(args.length > 0){
            Player p = (Player) sender;
            if(args[0].equalsIgnoreCase("pardoes")){
            	spawnArmorStand(p.getLocation(),"Pardoes",args[1], p);
            }
        } else {
            sender.sendMessage(ChatColor.GOLD + "Oops, te weinig argumentjes");
        }
		return false;
	}

	private void spawnArmorStand(Location location, String kostuum, String winkel, Player p) {
		ArmorStand e = location.getWorld().spawn(location, ArmorStand.class);
		if(kostuum.equalsIgnoreCase("pardoes")){
			Costume.PutCustome(e, kostuum, Color.RED, p);
			e.setCustomName("Pardoes");
			e.setCustomNameVisible(true);
			
		}
		
	}

}
