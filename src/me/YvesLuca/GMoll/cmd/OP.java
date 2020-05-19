package me.YvesLuca.GMoll.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.YvesLuca.GMoll.Main;

public class OP implements CommandExecutor{

	private Main plugin;
	public OP(Main instance) {
		plugin = instance;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("fight")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000 ,500));
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000 ,500));
				player.setAllowFlight(true);
				
				
			}
		}
		return false;
	
		
	}
	
}
