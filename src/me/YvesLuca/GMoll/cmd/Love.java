package me.YvesLuca.GMoll.cmd;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import at.pcgamingfreaks.MarriageMaster.Bukkit.API.MarriageMasterPlugin;
import me.YvesLuca.GMoll.Main;
import me.YvesLuca.GMoll.helper.LoveRequest;
import net.md_5.bungee.api.ChatColor;

public class Love implements CommandExecutor {
	
	private Main plugin;
	private MarriageMasterPlugin mm;
	
	private ArrayList<LoveRequest> loveList = new ArrayList<LoveRequest>();
	
	
	public Love(Main main) {
		this.plugin = main;
		this.mm = (MarriageMasterPlugin) main.getServer().getPluginManager().getPlugin("MarriageMaster");
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
							partner.sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + " möchte mit dir Spaß haben ;). Mach " + ChatColor.GREEN + "/loveaccept" + ChatColor.LIGHT_PURPLE + " um mit " + player.getName() + " zu " + ChatColor.RED + "vögeln!");
							loveList.add(new LoveRequest(player, partner, true));
							return(true);
						} else if(args[0].equalsIgnoreCase("unprotected")) {
							partner.sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + " möchte mit dir ein Baby machen ;). Mach " + ChatColor.GREEN + "/loveaccept" + ChatColor.LIGHT_PURPLE + " um mit " + player.getName() + ChatColor.RED + " ungeschützt zu vögeln!");
							loveList.add(new LoveRequest(player, partner, false));
							return(true);
						} else {
							player.sendMessage("Verwendung: /love <fun/unprotected> <player>");
						}
						
					} else {
						player.sendMessage("Verwendung: /love <fun/unprotected> <player>");
					}
					
				}	
			
		} else if(label.equalsIgnoreCase("loveaccept")) {
			if(sender instanceof Player) {
				Player partner = (Player) sender;
				
				LoveRequest lq = this.getLoveRequest(partner);
				if(lq != null) {
					if(lq.isFun()) {
						this.fun(lq.getPlayer(), lq.getPartner());
						this.loveList.remove(lq);
					} else {
						this.unprotected(lq.getPlayer(), lq.getPartner());
						this.loveList.remove(lq);
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
		Location playerLocation = player.getLocation();
		Location partnerLocation = partner.getLocation();
		double distance = playerLocation.distance(partnerLocation);
		
		if(distance > 3) {
			player.sendMessage("Du kannst erst mit " + partner.getName() + " vögeln, wenn ihr nah genung zusammen seid!");
			partner.sendMessage("Du kannst erst mit " + player.getName() + " vögeln, wenn ihr nah genung zusammen seid!");
			return;
		}
		
		this.loveAnim(player, partner, playerLocation, partnerLocation);
		plugin.getServer().broadcastMessage(ChatColor.RED + player.getName() + " bumst mit " + partner.getName() + " aus Spaß");
		
	}
	
	private void unprotected(Player player, Player partner) {
		if(!(partner.getName().equals(mm.getPlayerData(player).getPartner().getPlayer().getName()))) {
			player.sendMessage("Du kannst erst mit " + partner.getName() + " ein Kind machen, wenn ihr verheiratet seid!");
			partner.sendMessage("Du kannst erst mit " + player.getName() + " ein Kind machen, wenn ihr verheiratet seid!");
			return;
		}
		
		Location playerLocation = player.getLocation();
		Location partnerLocation = partner.getLocation();
		double distance = playerLocation.distance(partnerLocation);
		
		if(distance > 3) {
			player.sendMessage("Du kannst erst mit " + partner.getName() + " vögeln, wenn ihr nah genung zusammen seid!");
			partner.sendMessage("Du kannst erst mit " + player.getName() + " vögeln, wenn ihr nah genung zusammen seid!");
			return;
		}
		
		plugin.getServer().broadcastMessage(ChatColor.RED + player.getName() + " macht ein Baby mit " + partner.getName());
		this.loveAnim(player, partner, playerLocation, partnerLocation);
		
		Villager v = (Villager) player.getWorld().spawnEntity(playerLocation, EntityType.VILLAGER);
		v.setBaby();
		
	}
	
	private void loveAnim(Player player, Player partner, Location playerLocation, Location partnerLocation) {
		Random rand = new Random();
		int low = 7;
		int high = 15;
		int loveLength = rand.nextInt(high-low) + low;
		
		for(int i = 0; i < loveLength; i++) {	//jeweils ein rein und raus
			float vol1 = (float) ((Math.random() * (5 - 0.1)) + 0.1);
			float vol2 = (float) ((Math.random() * (5 - 0.1)) + 0.1);
			int time = (int) ((Math.random() * (1500 - 800)) + 800);
			
			player.spawnParticle(Particle.HEART, playerLocation.getX(), playerLocation.getY(), playerLocation.getZ(), 200);
			partner.spawnParticle(Particle.HEART, partnerLocation.getX(), partnerLocation.getY(), partnerLocation.getZ(), 200);
			
			player.playSound(playerLocation, Sound.ENTITY_VILLAGER_YES, (vol1*(i+1)), 1);
			partner.playSound(partnerLocation, Sound.ENTITY_VILLAGER_YES, (vol2*(i+1)), 1);
			
			if(player.getFoodLevel() < 4) {
				player.setFoodLevel(player.getFoodLevel() - 2);
			}
			
			if(partner.getFoodLevel() < 4) {
				partner.setFoodLevel(partner.getFoodLevel() - 2);
			}
			
			sleep(time);	//wait time between 800 and 1500
		}
		player.playSound(playerLocation, Sound.ENTITY_VILLAGER_HURT, 100, 1);
		partner.playSound(partnerLocation, Sound.ENTITY_VILLAGER_HURT, 100, 1);
		
	}
	
	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}