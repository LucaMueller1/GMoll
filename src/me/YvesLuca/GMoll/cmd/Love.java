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

	public Love(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("love")) {
				Player player = (Player) sender;
				Location l = player.getLocation();
				player.spawnParticle(Particle.HEART, l.getX(), l.getY(), l.getZ(), 200);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Villager v = (Villager) player.getWorld().spawnEntity(l, EntityType.VILLAGER);
				v.setBaby();
				
				
			
			}
		
		
		
		
		return false;
	}

}