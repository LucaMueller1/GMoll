package me.YvesLuca.GMoll.cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminShop implements CommandExecutor{

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equals("shop")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("gmoll.Shop")) {
					if(args[0] == null) {
						player.sendMessage("Server >> Bitte benutze /shop buy [ITEM] [ANZAHL] oder /shop sell");
					}
					if(args[0].equals("buy") && args[1] != null) {
						if(args[2] == null) {
							player.sendMessage("Gebe hier noch die Anzahl an");
						} else {
							onBuy(player);
						}
					} else {
						player.sendMessage("Bitte gebe hier EIN gültiges Item ein");
					}
					if(args[0].equals("sell")) {
						onSell(player);
					}
				}

			}
		
		}
		return false;
	}
	
	
	public void onBuy(Player player) {
		player.sendMessage("Du BUYEST");
	}
	
	public void onSell(Player player) {
		player.sendMessage("Du Sellst");
	}
}
