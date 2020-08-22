package me.YvesLuca.GMoll;


import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import com.earth2me.essentials.IEssentials;

import me.YvesLuca.GMoll.cmd.*;

import me.YvesLuca.GMoll.events.OneSleep;
import me.YvesLuca.GMoll.events.Welcome;
import me.YvesLuca.GMoll.events.Whitelister;
import net.md_5.bungee.api.ChatColor;


public class Main extends JavaPlugin implements Listener{
	
	
	private IEssentials ess;
	private PluginManager pm;
	private Gamble casino;
	
	@Override
	public void onEnable() {
		new Config();
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
		Log.info(ChatColor.DARK_AQUA + "GMoll wurde disabled :(");
	}
	
	private void registercmd() {
		Love love = new Love(this);
		this.getCommand("sign").setExecutor(new Sign(this));
		this.getCommand("fight").setExecutor(new OP(this));
		this.getCommand("die").setExecutor(new Die(this, ess));
		this.getCommand("eat").setExecutor(new Eat(this));
		this.getCommand("love").setExecutor(love);
		this.getCommand("loveaccept").setExecutor(love);
		this.getCommand("head").setExecutor(new Head(this, ess));
		this.getCommand("smallestb16").setExecutor(new Smallestb16(this));
		this.getCommand("cc").setExecutor(new ChatClear(this));
		this.getCommand("bank").setExecutor(new Bank(this, ess));
		this.getCommand("gamble").setExecutor(casino);
		
	
	}
	
	private void registerEvents() {
		pm.registerEvents(new Whitelister(this), this);
		pm.registerEvents(new Die(this, ess), this);
		pm.registerEvents(new OneSleep(this), this);
		pm.registerEvents(casino, this);
		pm.registerEvents(new Bank(this, ess), this);
		pm.registerEvents(new Welcome(this), this);
	}
	
	
}	
