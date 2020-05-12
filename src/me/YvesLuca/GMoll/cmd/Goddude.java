package me.YvesLuca.GMoll.cmd;

import java.math.BigDecimal;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;

import me.YvesLuca.GMoll.Main;
import net.ess3.api.MaxMoneyException;


public class Goddude implements CommandExecutor {

	private IEssentials ess;
	
	public Goddude(Main main, IEssentials ess2) {
		this.ess = ess;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equalsIgnoreCase("Goddude")) {
			Player player = (Player) sender;
			if(!(sender instanceof Player)) {
				sender.sendMessage("Du kannst diesen Befehl nicht ausführen!");
			} else {
				Location lc = new Location(player.getWorld(), -241, 64, 245);
				player.teleport(lc);
				player.setSneaking(true);
				User user = ess.getUser(player);
				BigDecimal cost = new BigDecimal(1);
				try {
					user.giveMoney(cost);
				} catch (MaxMoneyException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
