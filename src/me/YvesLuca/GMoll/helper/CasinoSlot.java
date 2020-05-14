package me.YvesLuca.GMoll.helper;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class CasinoSlot {

	private ItemStack displayItem;
	private double prob;
	private double payoutRate;
	private int payoutSlotCount;
	
	public CasinoSlot(ItemStack item, double prob, double pay, int payoutCount) {
		this.displayItem = item;
		this.prob = prob;
		this.payoutRate = pay;
		this.payoutSlotCount = payoutCount;
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

	public double getPayoutRate() {
		return payoutRate;
	}

	public void setPayoutRate(double payoutRate) {
		this.payoutRate = payoutRate;
	}

	public int getPayoutSlotCount() {
		return payoutSlotCount;
	}
}
