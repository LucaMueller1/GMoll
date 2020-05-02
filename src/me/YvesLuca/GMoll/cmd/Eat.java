package me.YvesLuca.GMoll.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.YvesLuca.GMoll.Main;
import net.md_5.bungee.api.ChatColor;

public class Eat implements CommandExecutor{

	static Main plugin;
		public Eat(Main instance) {
			plugin = instance;
		}
		
		
		// /feed
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
			if(label.equalsIgnoreCase("eat")) {
				if(!(sender.hasPermission("gmoll.eat"))) {
					sender.sendMessage(ChatColor.DARK_RED + "You can't use this command!");
					return true;	
				}
				if(!(sender instanceof Player)) {
					sender.sendMessage(ChatColor.DARK_RED + "You can't use this command!");
					return true;
				}
				Player player = (Player) sender;
				if(player.getFoodLevel() == 20) {
					sender.sendMessage(ChatColor.BLUE + "Du bist nicht hungrig!");
					return true;
				}
				player.setFoodLevel((int) plugin.getConfig().getDouble("feedAmount"));
				sender.sendMessage(ChatColor.GREEN + "War das nicht lecker?");
				return true;
			}
			
			return false;
		
	
		}
}