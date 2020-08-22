package me.YvesLuca.GMoll.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.YvesLuca.GMoll.Main;

public class ChatClear implements CommandExecutor {
	
	private Main plugin;
	
	public ChatClear(Main instance) {
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("cc")) {
		Player player = (Player) sender;
		if(!player.hasPermission("gmoll.cc")) {
			player.sendMessage("§6 Du hast keine Berechtigung!");
		} else {
			for(int i = 0; i < 200; ++i) {
				for(Player all : Bukkit.getOnlinePlayers()) {
						all.sendMessage(" ");
					}
			}
			Bukkit.broadcastMessage("§7 Der Chat wurde von §e" + player.getName() + "§7 geleert!");
			return true;
		}
		}
	   return false;
	}
	
}
