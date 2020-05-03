package me.YvesLuca.GMoll.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.IEssentials;

import me.YvesLuca.GMoll.Main;


public class Smallestb16 implements CommandExecutor {

	private Main plugin;
	//private MarriageMasterPlugin mm;
	
	public Smallestb16(Main instance) {
		plugin = instance;
		//this.mm = (MarriageMasterPlugin) plugin.getServer().getPluginManager().getPlugin("MarriageMaster");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("smallestb16")) {
			if(sender instanceof Player) {
				
				Player p = (Player) sender;
				
				if(p.getName().equals("AnY_Gamedude")) {
					Player smallestb16 = plugin.getServer().getPlayer("smallestb16");
					if(smallestb16 == null || !smallestb16.isOnline()) {
						p.sendMessage("Smallestb16 is not online ;(");
						return(false);
					}
					p.teleport(smallestb16.getLocation());
					p.performCommand("marry kiss");
					return(true);
				} else {
					p.sendMessage("Du: " + p.getName() + " bist nicht mit ihm Verheiratet, BITCH!");
					return(false);
				}
			}
			
		}
		return false;
	}

}
