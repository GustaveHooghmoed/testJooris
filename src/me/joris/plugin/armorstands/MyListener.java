package me.joris.plugin.armorstands;

import org.bloxy.costumes.main.Costume;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class MyListener implements Listener {
	
	@EventHandler
    public void buscarArmorStand(PlayerInteractAtEntityEvent e){
        Player player = e.getPlayer();
            if(e.getRightClicked() instanceof ArmorStand){
            	if(e.getRightClicked().getCustomName().equalsIgnoreCase("Pardoes")){
            		e.setCancelled(true);
            		Costume.PutCustomeOnPlayer(player,e.getRightClicked().getCustomName());
            	} else {
            		e.setCancelled(false);
            	}
                
        }
    }
}
