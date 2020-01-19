package fr.azrock.me.Warps;

import org.bukkit.Location;

import fr.azrock.me.ConfigurationFiles.Config;

public class Warp {
	
	public static Config config = new Config("Warps", "warps");
	
	private String warpName;
	private Location warpLoc;
	private int minPower;
	
	private final String PATH = "warps."+warpName;
	
	
	
	public Warp(String name, Location loc, int minPowerRequired) {
		this.warpName = name;
		this.warpLoc = loc;
		this.minPower = minPowerRequired;
	}
	
	public void addWarp() {
		config.createPath(PATH);
		config.setPath(PATH, warpLoc);
		WarpManager.addWarp(this);
	}
	


	public Location getLocation() {
		return warpLoc;
	}


	public String getName() {
		return warpName;
	}

	public int getMinPower() {
		return minPower;
	}
	
	
	
	
	
	public static void setup() {
		config.setup();
	}
	
	public static Config getConfig() {
		return config;
	}
}