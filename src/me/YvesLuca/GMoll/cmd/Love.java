package me.YvesLuca.GMoll.cmd;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import me.YvesLuca.GMoll.Main;


public class Love implements CommandExecutor {

	private Main plugin;
	public Love(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//	/love <fun/unprotected> <player>
		
		if(label.equalsIgnoreCase("love") && args != null) {
				
				if(sender instanceof Player) {
					Player player = (Player) sender;
					
					if(args[0] != null && args[1] != null) {
						
						Player partner = plugin.getServer().getPlayer(args[1]);
						if(partner == null) {
							player.sendMessage("Your partner: " + args[1] + " is not online or does exist :(");
							return(false);
						}
						
						if(args[0].equalsIgnoreCase("fun")) {
							partner.sendMessage(player.getName() + " möchte mit dir Spaß haben ;). Mach /loveaccept um mit " + player.getName() + " zu vögeln!");
						} else if(args[0].equalsIgnoreCase("unprotected")) {
							partner.sendMessage(player.getName() + " möchte mit dir ein Baby haben! Mach /loveaccept um mit " + player.getName() + " ungeschützt zu vögeln!");
						} else {
							player.sendMessage("Verwendung: /love <fun/unprotected> <player>");
						}
						
					} else {
						player.sendMessage("Verwendung: /love <fun/unprotected> <player>");
					}
					
				}
				
				
				/*
				Location playerLocation = player.getLocation();
				player.spawnParticle(Particle.HEART, playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), 200);
				sleep(1000);
				Villager v = (Villager) player.getWorld().spawnEntity(playerLocation, EntityType.VILLAGER);
				v.setBaby();
				*/
				
			
		}
		
		
		return false;
	}
	
	private void fun(Player player, Player partner) {
		
	}
	
	private void unprotected(Player player, Player partner) {
		
	}
	
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}