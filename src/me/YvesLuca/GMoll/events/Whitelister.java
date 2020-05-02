package me.YvesLuca.GMoll.events;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import me.YvesLuca.GMoll.Main;


public class Whitelister implements Listener {
	
	private Main main;
	
	public Whitelister(Main main) {
		this.main = main;
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		int playerCount = main.getServer().getOnlinePlayers().size();
		
		if(playerCount <= 1) {
			Log.info("Whitelist enabled!");
			main.getServer().setWhitelist(true);
		}
	}

}
