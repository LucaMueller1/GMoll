package me.YvesLuca.GMoll.cmd;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;

import me.YvesLuca.GMoll.Main;
import net.md_5.bungee.api.ChatColor;



public class Entchantments implements CommandExecutor{
	
	
	
	private Main plugin;
	public Entchantments(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		ArrayList<String> enchantments = new ArrayList<String>();
		enchantments.add("mending");
		enchantments.add("fireaspect");
		enchantments.add("sharppnes");
		enchantments.add("durability");
		enchantments.add("fireaspect");
		
//		enchantments.add("");
//		enchantments.add("");
		ItemStack Item = player.getPlayer().getInventory().getItemInMainHand();
		if(label.equalsIgnoreCase("genchant")) {
			if(sender instanceof Player) {
				if(player.hasPermission("gmoll.enchent")) {
					if(!(args.length == 0)) {
						if(args[1].equalsIgnoreCase("mending")) {
							Item.addEnchantment(Enchantment.MENDING, 1);
						} else if(args[1].equalsIgnoreCase("fireaspect")){
							Item.addEnchantment(Enchantment.FIRE_ASPECT, 5);
						} 
					} else {
						player.sendMessage("Das ist kein passendes Enchantment");
					}
				} else {
					player.sendMessage("Du hast dafür keine Berechtigung");
				}
			} else {
				player.sendMessage("Du hast diesen Befehl nicht ausführen");
			}
		} else {
			player.sendMessage("Dat passt net"	);
		}
		return false;
	}
	
	
}
