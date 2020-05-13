package me.YvesLuca.GMoll.helper;

import org.bukkit.entity.Player;

public class CasinoPlayer {

	private Player player;
	private int stake;
	
	public CasinoPlayer(Player p, int stake) {
		this.player = p;
		this.stake = stake;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getStake() {
		return stake;
	}

	public void setStake(int stake) {
		this.stake = stake;
	}
	
}
