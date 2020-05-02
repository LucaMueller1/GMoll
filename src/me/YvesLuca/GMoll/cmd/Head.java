package me.YvesLuca.GMoll.cmd;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import me.YvesLuca.GMoll.Main;

public class Head implements CommandExecutor{

	private Main plugin;
	private IEssentials ess;
	
	public Head(Main instance, IEssentials ess) {
		plugin = instance;
		this.ess = ess;
	}
		
		
		// /feed
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("gamedude")) {
			
			if(sender instanceof Player) {
				Player player = (Player) sender;
				
				User user = ess.getUser(player);
				BigDecimal money = user.getMoney();
				
				BigDecimal loss = new BigDecimal(10);
				loss.setScale(2, RoundingMode.HALF_EVEN);
				double tmp = money.doubleValue();
				
				player.sendMessage("Geld du fisch: " + tmp);
				
				user.takeMoney(loss);
			}
			
			return(true);
		} else if(label.equalsIgnoreCase("testHead")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				cmdTestHead(player);
			}
		} else if(label.equalsIgnoreCase("ghead")) {	//	/ghead burger
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(args != null && args[0] != null) {
					givePlayerHead(player, args[0]);	// burger					
				} else {
					player.sendMessage("Bitte gib einen verfügbaren Kopf ein!");
				}
			}
		}
		
		return(false);

	}
	
	private void cmdTestHead(Player player) {
		ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbti = new NBTItem(head);
        NBTCompound disp = nbti.addCompound("display");
        disp.setString("Name", "Testitem");
        //List<String> lore = disp.getStringList("Lore");
        //lore.add("Komm doch mal bei uns in Greasy Grove vorbei!");
        
        NBTCompound skull = nbti.addCompound("SkullOwner");
        skull.setString("Name", "Durr Burger");
        skull.setString("Id", "8301e4c1-d76a-4667-a782-9944431f1a59");
        NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
        texture.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTZkOWQ2ZDFmMDE1ZjEyYzI4Yjg1MjUzN2NkNzQ2MzUzMzNkNTI5MWZmYmY5Y2I3ZTQ0NDI1YTU0MDQ1YjMwNSJ9fX0=");
        
        /*	Special Attributes
        NBTCompoundList attribute = nbti.getCompoundList("AttributeModifiers");
        NBTListCompound mod1 = attribute.addCompound();
        mod1.setInteger("Amount", 10);
        mod1.setString("AttributeName", "generic.maxHealth");
        mod1.setString("Name", "generic.maxHealth");
        mod1.setInteger("Operation", 0);
        mod1.setInteger("UUIDLeast", 59664);
        mod1.setInteger("UUIDMost", 31453);

        nbti.setInteger("HideFlags", 4);
        nbti.setBoolean("Unbreakable", true);
        */
        
        head = nbti.getItem();
        
        List<String> lore = new ArrayList<String>();
        lore.add("Komm doch mal bei uns in Greasy Grove vorbei!");
        ItemMeta meta = head.getItemMeta();
        meta.setLore(lore);
        head.setItemMeta(meta);
        
        player.getInventory().addItem(head);
	}
	
	private void givePlayerHead(Player player, String headName) {
		headName = headName.toLowerCase();
		if(!(this.plugin.getConfig().contains(headName))) {
			player.sendMessage("Der Kopf " + headName + " existiert nicht");
			return;
		}
		
		
		String nameCfg = this.plugin.getConfig().getString(headName + ".name");
		String loreCfg = this.plugin.getConfig().getString(headName + ".lore");
		String idCfg = this.plugin.getConfig().getString(headName + ".id");
		String valueCfg = this.plugin.getConfig().getString(headName + ".value");
		Double costCfg = this.plugin.getConfig().getDouble(headName + ".cost");
		
		BigDecimal cost = new BigDecimal(costCfg);
		
		User user = ess.getUser(player);
		if(user.getMoney().compareTo(cost) >= 0) {
			user.takeMoney(cost);
		} else {
			player.sendMessage("Du bist nicht reich genug, um dir diesen Kopf zu kaufen!");
			return;
		}
		
		
		ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbti = new NBTItem(head);
        NBTCompound disp = nbti.addCompound("display");
        disp.setString("Name", "Testitem");
        List<String> l = disp.getStringList("Lore");
        l.add(loreCfg);
        NBTCompound skull = nbti.addCompound("SkullOwner");
        skull.setString("Name", nameCfg);
        skull.setString("Id", idCfg);
        NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
        texture.setString("Value", valueCfg);
        
        head = nbti.getItem();
        
        List<String> lore = new ArrayList<String>();
        lore.add(loreCfg);
        ItemMeta meta = head.getItemMeta();
        meta.setLore(lore);
        head.setItemMeta(meta);
        
        player.getInventory().addItem(head);
	}
	
}