package me.YvesLuca.GMoll.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;


public class Help implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("gmoll") && args != null) {
			if(args[0].equalsIgnoreCase("help")) {
				if(sender instanceof Player) {
					Player player = (Player) sender;
					player.performCommand("help gmoll");
					return(true);
				}
				
				

			}
		}
			
		return false;
	}

}
