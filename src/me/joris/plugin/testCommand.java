package me.joris.plugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class testCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args[0].length() > 0){
			sender.sendMessage(ChatColor.GOLD + "hallo wereld");
        } else {
        	sender.sendMessage(ChatColor.GOLD + "Oops, te weinig argumentjes");
        }
		return false;
	}

}
