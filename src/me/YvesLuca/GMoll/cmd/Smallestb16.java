package me.YvesLuca.GMoll.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.IEssentials;

import me.YvesLuca.GMoll.Main;

	
	

public class Smallestb16 implements CommandExecutor{

	private Main plugin;
	private IEssentials ess;
	
	public Smallestb16(Main instance, IEssentials ess) {
		plugin = instance;
		this.ess = ess;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("smallestb16")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Player smallestb16 = plugin.getServer().getPlayer("smallestb16");
				p.teleport(smallestb16.getLocation());
			}
			
		}
		return false;
	}

}
