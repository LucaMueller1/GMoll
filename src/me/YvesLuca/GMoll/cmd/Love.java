package me.YvesLuca.GMoll.cmd;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import me.YvesLuca.GMoll.Main;
import me.YvesLuca.GMoll.helper.LoveRequest;

public class Love implements CommandExecutor {
	
	private Main plugin;
	
	
	private ArrayList<LoveRequest> loveList = new ArrayList<LoveRequest>();
	
	
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
							loveList.add(new LoveRequest(player, partner, true));
							return(true);
						} else if(args[0].equalsIgnoreCase("unprotected")) {
							partner.sendMessage(player.getName() + " möchte mit dir ein Baby haben! Mach /loveaccept um mit " + player.getName() + " ungeschützt zu vögeln!");
							loveList.add(new LoveRequest(player, partner, false));
							return(true);
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
				
			
		} else if(label.equalsIgnoreCase("loveaccept")) {
			if(sender instanceof Player) {
				Player partner = (Player) sender;
				
				LoveRequest lq = this.getLoveRequest(partner);
				if(lq != null) {
					if(lq.isFun()) {
						this.fun(lq.getPlayer(), lq.getPartner());
					} else {
						this.unprotected(lq.getPlayer(), lq.getPartner());
					}
				} else {
					partner.sendMessage("Es gibt niemanden der mit dir schlafen will!");
				}
				
			}
		}
		
		
		return false;
	}
	
	private LoveRequest getLoveRequest(Player partner) {
		for(int i = 0; i < loveList.size(); i++) {
			if(loveList.get(i).getPartner().getName().equals(partner.getName())) {
				return(loveList.get(i));
			}
		}
		return(null);
	}
	
	private void fun(Player player, Player partner) {
		plugin.getServer().broadcastMessage(player.getName() + " bumst mit " + partner.getName() + " aus Spaß");
	}
	
	private void unprotected(Player player, Player partner) {
		plugin.getServer().broadcastMessage(player.getName() + " macht ein Baby mit " + partner.getName());
	}
	
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}