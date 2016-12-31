package me.joris.plugin.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.eclipse.jetty.server.Request;

import me.joris.plugin.main;
import me.joris.plugin.api.Bukkit.BukkitWebEvent;
import me.joris.plugin.api.WebServers.API;
import me.joris.plugin.api.WebServers.API.WebServer;

public class api implements Listener {
	
	public void registerWebPanel(){
		org.bukkit.Bukkit.getServer().getScheduler().runTaskAsynchronously(main.getInstance(), new Runnable(){
		    @Override
		    public void run() {
		        WebServer server = API.createServer(8002, "BungeeWebServer", "");
		        try{
		            server.start();
		            
		        } catch(Exception e){
		        }
		    }
		});
	}
	
	@EventHandler
	public void onWebEvent(BukkitWebEvent e) throws IOException{
	    WebServer server = e.getHandler().getServer();
	    String target = e.getTarget();
	    Request baseReq = e.getBaseReq();
	    HttpServletRequest req = e.getRequest();
	    HttpServletResponse res = e.getResponse();
	    if(e.getPort() == server.getPort()){
	    	if (target.equals("/")) {
	    	    target = "/index.html";
	    	}
	    	String[] path = target.split("/");
	    	if (path.length > 1 && path[1].equalsIgnoreCase("login")) {
	    		res.setContentType("text/html");
	    		res.getWriter().print("<h1>It works!</h1>");
	    	} else if(path.length > 1 && path[1].equalsIgnoreCase("logout")){
	    		res.setContentType("text/html");
	    		res.getWriter().print("<h1>It works! Logout!</h1>");
	    	    } else e.setCancelled(true);
	    	}
	    }
	
}
