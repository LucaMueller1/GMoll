package me.YvesLuca.GMoll;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.IEssentials;

import me.YvesLuca.GMoll.cmd.*;
import me.YvesLuca.GMoll.events.OneSleep;
import me.YvesLuca.GMoll.events.Whitelister;


public class Main extends JavaPlugin implements Listener{
	
	
	private IEssentials ess;
	private PluginManager pm;
	private Gamble casino;
	
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		pm = this.getServer().getPluginManager();
		ess = (IEssentials) pm.getPlugin("Essentials");
		casino = new Gamble(this, ess);
		
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
		
		Love love = new Love(this);
		this.getCommand("love").setExecutor(love);
		this.getCommand("loveaccept").setExecutor(love);
		this.getCommand("head").setExecutor(new Head(this, ess));
		this.getCommand("smallestb16").setExecutor(new Smallestb16(this));
		this.getCommand("muffintv").setExecutor(new MuffinTv(this));
		this.getCommand("cc").setExecutor(new ChatClear(this));
		this.getCommand("Goddude").setExecutor(new Goddude(this, ess));
		this.getCommand("bank").setExecutor(new Bank(this, ess));
		this.getCommand("gamble").setExecutor(casino);
	
	}
	
	private void registerEvents() {
		pm.registerEvents(new Whitelister(this), this);
		pm.registerEvents(new Die(this, ess), this);
		pm.registerEvents(new OneSleep(this), this);
		pm.registerEvents(casino, this);
		pm.registerEvents(new Bank(this, ess), this);
	}
}	
