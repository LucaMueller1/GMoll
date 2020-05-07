package me.YvesLuca.GMoll.cmd;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.YvesLuca.GMoll.Main;

public class MuffinTv implements CommandExecutor {

	private Main plugin;
	
	public MuffinTv(Main instance) {
		plugin = instance;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("MuffinTv")) {
			if(sender instanceof Player) {
				
				Player player = (Player) sender;
				
				Player Muffin_Tv11 = plugin.getServer().getPlayer("Muffin_Tv11");
				if(Muffin_Tv11 == null || !Muffin_Tv11.isOnline()) {
					player.sendMessage("Der Asi is not online haha ;(");
					return(false);
				}else {
					Location location = Muffin_Tv11.getLocation();
					location.setY(location.getY() + 3);
					Muffin_Tv11.teleport(location);
					Muffin_Tv11.sendMessage("Du wurdest vergewa****");
					player.sendMessage("Müffin haste ge*****");
					return true;
				}
				
			}
		}
		return false;
	}

}
