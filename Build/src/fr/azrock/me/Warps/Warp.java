package fr.azrock.me.Warps;

import org.bukkit.Location;

public class Warp {

	private String warpName;
	private Location warpLocation;
	private int powerRequired;
	
	public Warp(String warpName, Location loc, int powerToAccess) {
		this.warpName = warpName;
		this.warpLocation = loc;
		this.powerRequired = powerToAccess;
	}
	
	
	public void storeInConfig() {
		
	}


	
	public String getName() {
		return warpName;
	}


	public Location getLocation() {
		return warpLocation;
	}


	public int getPowerToAccess() {
		return powerRequired;
	}
	
}
