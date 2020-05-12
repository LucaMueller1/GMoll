package me.YvesLuca.GMoll.cmd;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;

import net.md_5.bungee.api.ChatColor;
import me.YvesLuca.GMoll.Main;

public class Bank implements CommandExecutor, Listener {
	
	Main plugin;
	public Bank(Main main) {
		plugin = main;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("bank")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.DARK_RED + "You cannot use this Command");
				return true;
			}
			Player player = (Player) sender;
			openGUI(player);
			return true;
		}
						
		return false;
	}
	
	public void openGUI(Player player) {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_AQUA + "Lucky Store");
		
		ItemStack item = new ItemStack(Material.PAPER);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_AQUA + "10k");
		
	    List<String> lore = new ArrayList<String>();
	    lore.add("");
	    lore.add(ChatColor.GOLD + "Click to buy/put in Inventory");
	    lore.add(ChatColor.AQUA + "$10.000");
	    meta.setLore(lore);
	    
	    item.setItemMeta(meta);
	    
	    inv.setItem(4, item);
	    
	    player.openInventory(inv);
	}
	
	private ItemStack item10k = null;
	
	
	
	public ItemStack giveItem(String name) {
		
		item10k = new ItemStack(Material.PAPER);
		ItemMeta meta = item10k.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_AQUA + "$10.000");
		
	    List<String> lore = new ArrayList<String>();
	    lore.add("");
	    lore.add(ChatColor.GOLD + ""  + ChatColor.ITALIC + "Gift Card");
	    lore.add(ChatColor.AQUA + "" + ChatColor.ITALIC + "$10.000");
	    meta.setLore(lore);
	    
	    item10k.setItemMeta(meta);
		
	    return item10k;
	}
	
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(!ChatColor.stripColor(e.getView().getTitle().toString()).equalsIgnoreCase("Lucky Store")) return;
		if(e.getCurrentItem() == null) return;
		if(e.getCurrentItem().getItemMeta() == null) return;
		if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		if(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equalsIgnoreCase("10k")){
			Player player = (Player)e.getWhoClicked();
			IEssentials ess = (IEssentials) plugin.getServer().getPluginManager().getPlugin("Essentials");
			User user = ess.getUser(player);
			
			BigDecimal price = new BigDecimal(10000);
			if(user.getMoney().compareTo(price) >= 0) {
																	
				user.takeMoney(price);
				player.getInventory().addItem(giveItem(player.getName()));
				player.closeInventory();
				e.setCancelled(true);
				
			} else {
				player.sendMessage("Das kannste nicht kaufen, " + ChatColor.AQUA + "du FICH");
				player.closeInventory();
				e.setCancelled(true);
				
				
			}
		  
		
		}

	}
	
	public ItemStack getItem10k() {
		return this.item10k;
	}
}