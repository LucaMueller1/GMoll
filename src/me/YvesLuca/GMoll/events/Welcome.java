package me.YvesLuca.GMoll.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.YvesLuca.GMoll.Main;
import net.md_5.bungee.api.ChatColor;

public class Welcome implements Listener{
	
	private Main plugin;
	
	public Welcome(Main main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void WEvent(PlayerJoinEvent e) {
		e.setJoinMessage("");
		Player player = (Player) e.getPlayer();
		String player2 = (String) e.getPlayer().getName();
		player.sendMessage(ChatColor.DARK_AQUA + "Willkommen " + ChatColor.DARK_RED + ChatColor.BOLD + player2 + ChatColor.AQUA + " auf dem Community Server" + "           ----hab wie immer SPAß!----");
		player.giveExp(1);
		int healt = (int) player.getHealth();
		player.setHealth(healt + 1);
		int food = (int) player.getFoodLevel();
		player.setFoodLevel(food + 2);
		
	}
	@EventHandler
	public void QuitEvent(PlayerQuitEvent ev) {
		ev.setQuitMessage("");
	}
	
		

}
