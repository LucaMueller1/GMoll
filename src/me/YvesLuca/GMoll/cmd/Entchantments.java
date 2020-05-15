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
		
		ArrayList<String> enchantments = new ArrayList<String>();
		enchantments.add("mending");
		enchantments.add("fireaspect");
		enchantments.add("sharppnes");
		enchantments.add("durability");
		enchantments.add("fireaspect");
		
//		enchantments.add("");
//		enchantments.add("");
		if(label.equalsIgnoreCase("genchant") && args != null) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				if(args.length >= 1) {	
					System.out.println("Das Enchantments wurde nicht gefunden!");
					 ItemStack ench = player.getPlayer().getInventory().getItemInMainHand();
					if(ench == null) {
						player.sendMessage(ChatColor.DARK_AQUA + "Bitte halte einen Gegenstandt, während du diesen Command benutzt!");
					}else if(enchantments.get(0).equals("mending")) {
						ench.addEnchantment(Enchantment.MENDING, 1);
					}else if(enchantments.get(1).equals("fireaspect")) {
						ench.addEnchantment(Enchantment.FIRE_ASPECT, 2);
					}else if(enchantments.get(2).equals("sharppnes")) {
						ench.addEnchantment(Enchantment.DAMAGE_ALL, 6);
					}else if(enchantments.get(3).equals("durability")) {
						ench.addEnchantment(Enchantment.DURABILITY, 5);
					}else if(enchantments.get(4).equals("mending")) {
						ench.addEnchantment(Enchantment.MENDING, 1);
					}
					
				}
				
			}
			
		}
		
		
		
		
		

		return false;
	}
	
	
}
