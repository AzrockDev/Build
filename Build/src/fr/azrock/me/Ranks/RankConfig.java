package fr.azrock.me.Ranks;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.Build;

public class RankConfig {

	
	private static JavaPlugin plugin = Build.getPlugin();
	
	
	public void createNewPlayerFile(Player player) {
		plugin.getConfig().createSection("Ranks."+player.getUniqueId());
		plugin.getConfig().set("Ranks."+player.getUniqueId(), RankType.PLAYER.power);
		plugin.saveConfig();
	}
	
	public boolean hasConfigSection(Player player) {
		return plugin.getConfig().getConfigurationSection("Ranks."+player.getUniqueId()) != null;
	}
	
	
	
	public void setNewRank(Player player, RankType rank) {
		plugin.getConfig().set("Ranks."+player.getUniqueId(), rank.getPower());
		plugin.saveConfig();
	}
	
	public int getRankID(Player player) {
		return plugin.getConfig().getInt("Ranks."+player.getUniqueId());
	}
	
	
	
	
	
	public static RankConfig getInstance() {
		return new RankConfig();
	}
}
