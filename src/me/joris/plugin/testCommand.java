package me.joris.plugin;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import coinsapi.api.methodsAPI;

public class testCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if(args.length > 0){
            sender.sendMessage(ChatColor.GOLD + "hallo wereld");
            Player p = (Player) sender;
            methodsAPI eco = new methodsAPI(p.getUniqueId(),p);
            try {
				eco.setMoney(Integer.valueOf(args[1]));
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            sender.sendMessage(ChatColor.GOLD + "Oops, te weinig argumentjes");
        }
		return false;
	}

}
