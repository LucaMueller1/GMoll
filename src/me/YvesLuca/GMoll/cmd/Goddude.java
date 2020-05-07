package me.YvesLuca.GMoll.cmd;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Goddude implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("Goddude")) {
			Player player = (Player) sender;
			if(!(sender instanceof Player)) {
				sender.sendMessage("Du kannst diesen Befehl nicht ausführen!");
			}else {
				Location lc = new Location(null, -241, 64, 245);
				player.teleport(lc);
				player.setSneaking(true);
			}
		}
		return false;
	}
	
}
