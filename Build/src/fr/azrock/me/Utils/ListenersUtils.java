package fr.azrock.me.Utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.azrock.me.Ranks.RankListeners;

public class ListenersUtils {

	private static ListenersUtils instance = new ListenersUtils();
	
	
	public void registerListeners(Plugin plugin) {
		PluginManager pm =  Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new RankListeners(), plugin);
	}
	
	public static ListenersUtils getInstance() {
		return instance;
	}
	
}
