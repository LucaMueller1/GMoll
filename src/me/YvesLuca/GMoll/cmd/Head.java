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

public class Head implements CommandExecutor {

	private Main plugin;
	private IEssentials ess;
	
	public Head(Main instance, IEssentials ess) {
		plugin = instance;
		this.ess = ess;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("head")) {	//	/head burger
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(args != null && args[0] != null) {
					givePlayerHead(player, args[0]);	// burger					
				} else {
					player.sendMessage("Bitte gib einen verfügbaren Kopf ein!");
				}
			}
			return(true);
		}
		
		return(false);

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