package me.YvesLuca.GMoll.cmd;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.earth2me.essentials.IEssentials;
import com.earth2me.essentials.User;

import me.YvesLuca.GMoll.*;
import me.YvesLuca.GMoll.helper.Experience;
import net.md_5.bungee.api.ChatColor;

public class Die implements CommandExecutor, Listener {
	
	private Main plugin;
	private IEssentials ess;
	
	public Die(Main main, IEssentials ess) {
		plugin = main;
		this.ess = ess;
	}
	
	// /die command
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("die")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				player.setHealth(0);
				Bukkit.broadcastMessage(ChatColor.AQUA + player.getName() + " hatte keine Lust mehr in der selben Welt wie Muffin_Tv11 zu leben!");
				
				
			}	
			return true;
		}
		return false;
	}
	
	
	//on player death event
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		
		User user = ess.getUser(player);
		BigDecimal money = user.getMoney();
		
		Double lossDouble = plugin.getConfig().getDouble("lossPercentage");
		BigDecimal lossPercentage = new BigDecimal(lossDouble);
		BigDecimal loss = money.multiply(lossPercentage);
		
		BigDecimal maxLoss = new BigDecimal(5000);
		if(loss.compareTo(maxLoss) > 0) {
			loss = maxLoss;
		}
		
		loss.setScale(2, RoundingMode.HALF_EVEN);
		
		if(loss.compareTo(BigDecimal.ZERO) > 0) {
			player.sendMessage("Du bist gestorben und hast " + loss.doubleValue() + "$ verloren!");
			
			user.takeMoney(loss);
		}
			
	}
	
}
