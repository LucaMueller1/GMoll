package me.YvesLuca.GMoll.events;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.connorlinfoot.actionbarapi.ActionBarAPI;

import me.YvesLuca.GMoll.Config;
import me.YvesLuca.GMoll.*;

public class LevelSystem implements Listener {
	
	int currentXP =0;
	int level = 1;
	int finalXP = 2;
	
	
	private Main plugin;
	
	public LevelSystem(Main main) {
		this.plugin = main;
		
	}


	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) throws IOException {
		Block block = e.getBlock();
		Player playerID = e.getPlayer();
		
		if(block.getType().equals(Material.IRON_ORE)) {
			if(Config.contains("Leveling." + playerID.getUniqueId().toString() + ".ID")) {
				
//-> Get int's from Config			
			int level = (int) Config.get("Leveling." + playerID.getUniqueId().toString() + ".Level");
			int	currentXP = (int) Config.get("Leveling." + playerID.getUniqueId().toString() + ".CurrentXP");
			int	finalXP = (int) Config.get("Leveling."  + playerID.getUniqueId().toString() + ".FinalXP");
			Player player = Bukkit.getPlayer((String) Config.get("Leveling." + playerID.getUniqueId().toString() + ".ID"));
//---------------------------------------------------------------------------------------------------
//-> Programm and save int's
				
				currentXP++;
				
				if(currentXP == finalXP) {
					finalXP = finalXP*2;
					level++;
				}
				
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".CurrentXP", currentXP);
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".Level", level);
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".FinalXP", finalXP);
				
				String leveling = ChatColor.AQUA + "" + ChatColor.ITALIC + "Mining Level " + level + " [ " + currentXP + "/" + finalXP + " ]";
				ActionBarAPI.sendActionBar(playerID, leveling);
				
			} else {
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".ID", playerID.getUniqueId().toString());
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".Level", 1);
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".CurrentXP", 1);
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".FinalXP", 2);
				
				
				
				
				if(currentXP == finalXP) {
					
					finalXP = finalXP*2;
					
					level++;
				}
				
				Config.set("Leveling." + playerID.getUniqueId().toString() + ".CurrentXP", currentXP);
//				Config.set("Leveling." + playerID.getUniqueId().toString() + ".FinalXP", finalXP);
//				Config.set("Leveling." + playerID.getUniqueId().toString() + ".Level", level);
				
				String leveling = ChatColor.AQUA + "" + ChatColor.ITALIC + "Mining Level " + level + " [ " + currentXP + "/" + finalXP + " ]";
				ActionBarAPI.sendActionBar(playerID, leveling);
			}
		}	
	}
}