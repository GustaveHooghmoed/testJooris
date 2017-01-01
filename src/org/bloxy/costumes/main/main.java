package org.bloxy.costumes.main;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class main {
	
	  public static ItemStack costumeSkull(String name, String playername)
	  {
	    ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
	    SkullMeta im = (SkullMeta)is.getItemMeta();
	    im.setDisplayName(name);
	    im.setOwner(playername);
	    is.setItemMeta(im);
	    return is;
	  }
	  
	  public static ItemStack costumeItem(String name)
	  {
	    ItemStack is = new ItemStack(Material.ARMOR_STAND);
	    ItemMeta im = is.getItemMeta();
	    ArrayList<String> lore = new ArrayList();
	    im.setLore(lore);
	    im.setDisplayName(name);
	    is.setItemMeta(im);
	    return is;
	  }
	  
	  public static ItemStack costumeChest(String name, Color c)
	  {
	    ItemStack is = new ItemStack(Material.LEATHER_CHESTPLATE);
	    LeatherArmorMeta im = (LeatherArmorMeta)is.getItemMeta();
	    im.setDisplayName(name);
	    im.setColor(c);
	    is.setItemMeta(im);
	    return is;
	  }
	  
	  public static ItemStack costumeLeggings(String name, Color c)
	  {
	    ItemStack is = new ItemStack(Material.LEATHER_LEGGINGS);
	    LeatherArmorMeta im = (LeatherArmorMeta)is.getItemMeta();
	    im.setDisplayName(name);
	    im.setColor(c);
	    is.setItemMeta(im);
	    return is;
	  }
	  
	  public static ItemStack costumeBoots(String name, Color c)
	  {
	    ItemStack is = new ItemStack(Material.LEATHER_BOOTS);
	    LeatherArmorMeta im = (LeatherArmorMeta)is.getItemMeta();
	    im.setDisplayName(name);
	    im.setColor(c);
	    is.setItemMeta(im);
	    return is;
	  }

}
