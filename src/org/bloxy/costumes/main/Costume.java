package org.bloxy.costumes.main;

import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Costume {
	 
	public static void PutCustome(ArmorStand p, String customename, Color color, Player p1){
        p.setHelmet(main.costumeSkull(customename + " helmet", "EftelingPardoes"));
        
        p.setChestplate(main.costumeChest(customename +" ChestPlate", color));
        p.setLeggings(main.costumeLeggings(customename +" Leggings", color));
        p.setBoots(main.costumeBoots(customename +" Boots", color));
        p1.playSound(p.getLocation(), Sound.ENTITY_HORSE_SADDLE, 5.0F, 1.0F);
        if (p.getEquipment().getHelmet() != null) {
          p1.getInventory().addItem(new ItemStack[] { p.getEquipment().getHelmet() });
        }
        p1.playSound(p.getLocation(), Sound.ENTITY_HORSE_SADDLE, 5.0F, 1.0F);
	}

	public static void PutCustomeOnPlayer(Player p, String customName) {
		if(customName.equalsIgnoreCase("Pardoes")){
			String customename = customName;
			Color color = Color.RED;
			 p.getEquipment().setHelmet(main.costumeSkull(customename + " helmet", "EftelingPardoes"));
		        
		        p.getEquipment().setChestplate(main.costumeChest(customename +" chestplate", color));
		        p.getEquipment().setLeggings(main.costumeLeggings(customename +" leggings", color));
		        p.getEquipment().setBoots(main.costumeBoots(customename +" boots", color));
		}
		
       
		
	}

}
