package me.YvesLuca.GMoll.events;

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
	public void onSleep(PlayerBedEnterEvent PBEE) {
		int playercount = plugin.getServer().getOnlinePlayers().size();
		
		
	}
	
	public boolean setDay(int neededPlayers, Player cmdPlayer) {
		neededPlayers = (int) plugin.getConfig().getDouble("neededPlayers");
		int counter = 0;
		for(Player p : plugin.getServer().getOnlinePlayers()) {
			if(p.isSleeping()) {
				counter++;
			}
			
		}
		if(counter >= neededPlayers) {
			PlayerBedLeaveEvent QWER;
			cmdPlayer.getWorld().setTime(0);
			cmdPlayer.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 5 ,5));
			return true;
		} else {
			return false;
		}	
	}
}
