package me.YvesLuca.GMoll;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

//import me.YvesLuca.GMoll.cmd.Lucky;
//import me.YvesLuca.GMoll.cmd.LuckyVk;
//import me.YvesLuca.GMoll.cmd.BetterEntchantments;
import me.YvesLuca.GMoll.cmd.Die;
import me.YvesLuca.GMoll.cmd.Eat;
import me.YvesLuca.GMoll.cmd.Love;


public class Main extends JavaPlugin implements Listener{
	
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		registercmd();
		PluginManager pm = this.getServer().getPluginManager();
	//  pm.registerEvents(new Lucky(this), this);
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		
	}
	public void registercmd() {
		this.getCommand("die").setExecutor(new Die(this));
		this.getCommand("eat").setExecutor(new Eat(this));
		this.getCommand("love").setExecutor(new Love(this));
	//	this.getCommand("opstuff").setExecutor(new BetterEntchantments(this));
	//	this.getCommand("lucky").setExecutor(new Lucky(this));
		
	
	
	}
}	
