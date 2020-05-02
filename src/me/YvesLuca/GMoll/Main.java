package me.YvesLuca.GMoll;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.IEssentials;

//import me.YvesLuca.GMoll.cmd.Lucky;
//import me.YvesLuca.GMoll.cmd.LuckyVk;
//import me.YvesLuca.GMoll.cmd.BetterEntchantments;
import me.YvesLuca.GMoll.cmd.Die;
import me.YvesLuca.GMoll.cmd.Eat;
import me.YvesLuca.GMoll.cmd.Love;
import me.YvesLuca.GMoll.events.Whitelister;


public class Main extends JavaPlugin implements Listener{
	
	
	private IEssentials ess;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		registercmd();
		PluginManager pm = this.getServer().getPluginManager();
	//  pm.registerEvents(new Lucky(this), this);
		pm.registerEvents(new Whitelister(this), this);
		this.getServer().getPluginManager().registerEvents(this, this);
		
		ess = (IEssentials) pm.getPlugin("Essentials");
	}
	
	public void onDisable() {
		
	}
	public void registercmd() {
		this.getCommand("die").setExecutor(new Die(this, ess));
		this.getCommand("eat").setExecutor(new Eat(this));
		this.getCommand("love").setExecutor(new Love(this));
	//	this.getCommand("opstuff").setExecutor(new BetterEntchantments(this));
	//	this.getCommand("lucky").setExecutor(new Lucky(this));
		
	
	
	}
}	
