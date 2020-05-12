package me.YvesLuca.GMoll.helper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class CasinoSlot {

	private ItemStack displayItem;
	private double prob;
	
	public CasinoSlot(ItemStack item, double prob) {
		this.displayItem = item;
		this.prob = prob;
	}

	public ItemStack getDisplayItem() {
		return displayItem;
	}

	public void setDisplayItem(ItemStack displayItem) {
		this.displayItem = displayItem;
	}

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}
}
