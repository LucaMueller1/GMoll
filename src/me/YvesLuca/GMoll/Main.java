package me.YvesLuca.GMoll;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.IEssentials;

import me.YvesLuca.GMoll.cmd.*;
import me.YvesLuca.GMoll.events.Whitelister;


public class Main extends JavaPlugin implements Listener{
	
	
	private IEssentials ess;
	private PluginManager pm;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		pm = this.getServer().getPluginManager();
		ess = (IEssentials) pm.getPlugin("Essentials");
		
		//register Commands
		registercmd();
		
		//register Events
		this.registerEvents();
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void registercmd() {
		this.getCommand("die").setExecutor(new Die(this, ess));
		this.getCommand("eat").setExecutor(new Eat(this));
		this.getCommand("love").setExecutor(new Love(this));
		this.getCommand("loveaccept").setExecutor(new Love(this));
		this.getCommand("head").setExecutor(new Head(this, ess));
		this.getCommand("smallestb16").setExecutor(new Smallestb16(this));
		this.getCommand("gmoll").setExecutor(new Help());
	//	this.getCommand("opstuff").setExecutor(new BetterEntchantments(this));
	//	this.getCommand("lucky").setExecutor(new Lucky(this));
	
	}
	
	private void registerEvents() {
		pm.registerEvents(new Whitelister(this), this);
		pm.registerEvents(new Die(this, ess), this);
	}
}	
