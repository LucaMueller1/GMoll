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

import me.YvesLuca.GMoll.*;

public class LevelSystem implements Listener {
	
	int currentXP =0;
	int level = 1;
	int finalXP = 2;
	
	int i2 = 0;
	int level2 = 1;
	int wieviel2 = 2;
	
	private Main plugin;
	
	public LevelSystem(Main main) {
		this.plugin = main;
		
	}

/*	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		LivingEntity entity = event.getEntity();
		if(entity.getType() == EntityType.CHICKEN) {
			Player player = entity.getKiller();
			i2++;
			if(i2 == wieviel2) {
				level2++;
				wieviel2 = wieviel2*2;
			}
			
			
			String leveling = ChatColor.AQUA + "" + ChatColor.ITALIC + "Hunter Level " + level2 + " [ " + i2 + "/" + wieviel2 + " ]";
			ActionBarAPI.sendActionBar(player, leveling);
		}
		
	}
		
*/	
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) throws IOException {	 
		

		Block block = e.getBlock();
		Player player = e.getPlayer();
		if(block.getType() == Material.IRON_ORE) {
			if(Config.contains("XP.Player")) {
				player = Bukkit.getServer().getPlayer((String) Config.get("XP.Player.name"));
				currentXP = (int) Config.get("XP.Player.currentXP");
				finalXP = (int) Config.get("XP.Player.finalXP");
				level = (int) Config.get("XP.Player.level");
				
//------------------------------------------------------------------------------------------
				
				currentXP++;
				Config.set("XP.Player.currentXP", currentXP);
				if(currentXP == finalXP) {
					finalXP = finalXP * 2;
					Config.set("XP.Player.finalXP", finalXP);
					level++;
					Config.set("XP.Player.level", level);
				}
				
				
				String leveling = ChatColor.AQUA + "" + ChatColor.ITALIC + "Mining Level " + level + " [ " + currentXP + "/" + finalXP + " ]";
				//ActionBarAPI.sendActionBar(player, leveling);
				player.sendMessage(leveling);
			} else {
				Config.set("XP.Player.name", player.getName().toString());
				Config.set("XP.Player.currentXP", 1);
				Config.set("XP.Player.finalXP", 2);
				Config.set("XP.Player.level", 1);
				String leveling = ChatColor.AQUA + "" + ChatColor.ITALIC + "Mining Level " + level + " [ " + currentXP + "/" + finalXP + " ]";
				//ActionBarAPI.sendActionBar(player, leveling);
				player.sendMessage(leveling);
			}
				
			}
			
			
			
			/*  Block block = e.getBlock();
			 *	Player player = e.getPlayer();
			 *  if(block.getType() == Material.IRON_ORE)
			 *  currentXP++;
			 *  if(currentXP == finallXP)
			 *  finalXP = finallXP*2;
			 *  level++;
			 * 
			 * 
			 */
			
	}
		
}

	

