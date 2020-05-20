package me.YvesLuca.GMoll.cmd;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.YvesLuca.GMoll.Main;
import net.md_5.bungee.api.ChatColor;

public class Sign implements CommandExecutor{

	
	private Main plugin;
	public Sign(Main instance) {
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("sign")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(!(player.hasPermission("gmoll.sign"))) {
					player.sendMessage(ChatColor.AQUA + "Du hast keine Berechtigung dafür!");
				} else {
					ItemStack item = player.getInventory().getItemInMainHand();
					ItemMeta meta = item.getItemMeta();
					List<String> lore = new ArrayList<String>();
					String playername = (String) player.getName();
					lore.add(ChatColor.GRAY + "");
					lore.add(ChatColor.GRAY + "-----------------------");
					lore.add(ChatColor.GRAY + "Signiert von " +ChatColor.RESET + ChatColor.RED + playername);
					lore.add(ChatColor.GRAY + "-----------------------");
					meta.setLore(lore);
					item.setItemMeta(meta);
				}
			} else {
				sender.sendMessage("Du kannst diesen Befehl nicht ausführen!");
			}
		}
		return false;
		
	}
}
