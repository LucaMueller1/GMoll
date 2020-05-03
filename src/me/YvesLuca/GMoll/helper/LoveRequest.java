package me.YvesLuca.GMoll.helper;

import org.bukkit.entity.Player;

public class LoveRequest {

	private Player player;
	private Player partner;
	private boolean isFun;
	
	public LoveRequest(Player player, Player partner, boolean fun) {
		this.player = player;
		this.partner = partner;
		this.isFun = fun;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player getPartner() {
		return partner;
	}

	public void setPartner(Player partner) {
		this.partner = partner;
	}

	public boolean isFun() {
		return isFun;
	}

	public void setFun(boolean isFun) {
		this.isFun = isFun;
	}
	
	
	
}
