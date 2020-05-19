package me.YvesLuca.GMoll.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.YvesLuca.GMoll.Main;
import net.md_5.bungee.api.ChatColor;

public class Welcome implements Listener{
	
	private Main plugin;
	
	public Welcome(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void WEvent(PlayerJoinEvent e) {
		Player player = (Player) e.getPlayer();
		player.sendMessage(ChatColor.DARK_AQUA + "Willkommen " + ChatColor.DARK_RED + ChatColor.BOLD + player + ChatColor.AQUA + "auf dem Community Server" + ChatColor.YELLOW + "\nhab wie immer SPAß!");
		player.giveExp(1);
	}
	

}
