package me.YvesLuca.GMoll.cmd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;

import me.YvesLuca.GMoll.Main;
import me.YvesLuca.GMoll.helper.CasinoSlot;
import net.md_5.bungee.api.ChatColor;

public class Gamble implements CommandExecutor, Listener {
	
	private CasinoSlot[] casinoSlots;
	private int numSlots = 7;
	
	private Main plugin;
	public Gamble(Main main) {
		this.plugin = main;
		
		casinoSlots = new CasinoSlot[5];
		casinoSlots[0] = new CasinoSlot(new ItemStack(Material.EMERALD), 0.1);		//5%
		casinoSlots[1] = new CasinoSlot(new ItemStack(Material.DIAMOND), 0.15);		//15%
		casinoSlots[2] = new CasinoSlot(new ItemStack(Material.GOLD_INGOT), 0.2);	//20%
		casinoSlots[3] = new CasinoSlot(new ItemStack(Material.IRON_INGOT), 0.25);	//25%
		casinoSlots[4] = new CasinoSlot(new ItemStack(Material.COAL), 0.35);		//35%
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("gamble")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				this.openGambleScreen(player);
			}	
			return true;
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		
		if(!ChatColor.stripColor(e.getView().getTitle().toString()).equalsIgnoreCase("Feeling lucky?")) return;
		if(e.getCurrentItem() == null) return;
		/*
		if(e.getCurrentItem().getItemMeta() == null) return;
		if(e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		*/
		
		Player player = (Player) e.getWhoClicked();
		
		e.setCancelled(true);
		player.closeInventory();

	}

	private void openGambleScreen(Player player) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + "Feeling lucky?");
		
		ItemStack[] items = new ItemStack[numSlots];
		
		
		int preDelay = 0;
		
		for(int i = 0; i < numSlots; i++) {
			int time = 15;
			time += preDelay;
			
			final int it = i;
			
			
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, () -> setInv(items, inv, it, player), time);
			
			preDelay = time;
		}
	    
	    
	    player.openInventory(inv);
	}
	
	private void setInv(ItemStack[] items, Inventory inv, int i, Player player) {
		Random rnd = new Random();
	    int rndNum = rnd.nextInt(100) + 1;
	    
	    if(rndNum < 35 && rndNum >= 0) {	//coal
	    	items[i] = casinoSlots[4].getDisplayItem();
	    } else if(rndNum >= 35 && rndNum < 60) {	//iron
	    	items[i] = casinoSlots[3].getDisplayItem();
	    } else if(rndNum >= 60 && rndNum < 80) {	//gold
	    	items[i] = casinoSlots[2].getDisplayItem();
	    } else if(rndNum >= 80 && rndNum < 95) {	//diamond
	    	items[i] = casinoSlots[1].getDisplayItem();
	    } else if(rndNum >= 95 && rndNum < 100) {	//emerald
	    	items[i] = casinoSlots[0].getDisplayItem();
	    }
	    
	    inv.setItem(i+10, items[i]);
	    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
	}
	
	
	
}
