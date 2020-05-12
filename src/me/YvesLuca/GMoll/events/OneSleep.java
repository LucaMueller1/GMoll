package me.YvesLuca.GMoll.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


import me.YvesLuca.GMoll.Main;

public class OneSleep implements Listener{

private Main plugin;
	
	public OneSleep(Main main) {
		this.plugin = main;
	}
	
	
	@EventHandler
	public void onSleep(PlayerBedEnterEvent e) {
		int playercount = plugin.getServer().getOnlinePlayers().size();
		int neededPlayers = (int) plugin.getConfig().getDouble("neededPlayers");
		this.setDay(neededPlayers, e.getPlayer());
		
		
	}
	
	public boolean setDay(int neededPlayers, Player cmdPlayer) {
		int counter = 0;
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			if(p.isSleeping()) {
				counter++;
			}
			
		}
		if(counter >= neededPlayers) {
			cmdPlayer.getWorld().setTime(0);
			cmdPlayer.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 5 ,5));
			Bukkit.broadcastMessage(ChatColor.AQUA + "Morgen");
			return true;
		} else {
			return false;
		}	
	}
}
