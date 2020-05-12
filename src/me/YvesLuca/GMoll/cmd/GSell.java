package me.YvesLuca.GMoll.cmd;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.YvesLuca.GMoll.Main;


public class GSell implements CommandExecutor {

	
	Main plugin;
	Bank bank;
	
	
	public GSell(Main main) {
		plugin = main;
		bank = new Bank(plugin);
		bank.getItem10k();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,String label, String[] args) {

	
		if(label.equalsIgnoreCase("gsell")) {
			
			Player player = (Player) sender;
			ItemStack item10k = bank.getItem10k();
			if(!(player.getItemInHand().equals(item10k))) {
				player.sendMessage("§6Das ist kein passendes Item §4[z.B.: §a10k§4 ]");
			} else {
				player.setItemInHand(null);
				
			}
			
			
			
			
		}
		
		
		
		
		return false;
	}

}
