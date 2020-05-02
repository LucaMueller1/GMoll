package me.YvesLuca.GMoll.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import me.YvesLuca.GMoll.*;
import net.md_5.bungee.api.ChatColor;

public class Die implements CommandExecutor {
	
	static Main plugin;
	public Die(Main main) {
		plugin = main;
		
	}
	// /die
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("die")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.setHealth(0);
				Bukkit.broadcastMessage(ChatColor.DARK_RED + player.getName() + " hatte keine Lust mehr in der selben Welt wie Muffin_Tv11 zu leben");
			}	
			return true;
		}
		return false;
	}
	
}
