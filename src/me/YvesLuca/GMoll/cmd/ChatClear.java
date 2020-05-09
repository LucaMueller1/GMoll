package me.YvesLuca.GMoll.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(player.hasPermission("gmoll.cc")) {
				if(args.length == 0) {
					
					for(int i = 0; i <= 150; i++) {
						Bukkit.broadcastMessage(" ");
						Bukkit.broadcastMessage("§aDer Chat wurde von §6" + player.getName() + "§a geleert.");
						
					} 
					
				} else
				 	player.sendMessage("§cBitte benutze §6/cc§c!");
			} else
				player.sendMessage("&cDu hast keine Rechte");	
		}
		return false;
	}
	
}