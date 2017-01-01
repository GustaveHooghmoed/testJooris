package me.joris.plugin.api;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.java_websocket.server.WebSocketServer;

import me.joris.plugin.api.socket.WebsocketServer;
import me.joris.plugin.api.socket.WebsocketSessionManager;

public class data implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) org.bukkit.Bukkit.getPlayer(args[0]);
		if (WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()) != null) {
            WebsocketServer.s.sendData(WebsocketSessionManager.getSessionManager().getSessionByName(p.getName()), args[1]);
        }
		return false;
	}

}
