package fr.azrock.me;

import org.bukkit.plugin.java.JavaPlugin;

public class Build extends JavaPlugin {

	private static JavaPlugin instance;
	
	
	public void onEnable() {
		instance = this;
		instance.saveDefaultConfig();
		
		
		
	}
	
	
	
	
	public static JavaPlugin getPlugin() {
		return instance;
	}
}
