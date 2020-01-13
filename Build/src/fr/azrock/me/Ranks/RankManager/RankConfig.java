package fr.azrock.me.Ranks.RankManager;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.azrock.me.Ranks.RankType;

public class RankConfig {
		
	private static RankConfig instance = new RankConfig();
	
	private FileConfiguration config;
	private File configFile;
	private Plugin plugin;
	
	
	
	/*--------------------------------------------------------------------------------
	 * Setup main config. 
	 * Call method on enable to setup rank configuration.
	 * */
	public void setupConfig(Plugin plugin) {
		this.plugin = plugin;
		boolean b = false;
		
		
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		this.configFile = new File(plugin.getDataFolder(), "ranks.yml");
		
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
				b = true;
			}catch(Exception e) { e.printStackTrace(); }
		}
		
		this.config = YamlConfiguration.loadConfiguration(configFile);
		
		
		if(b) {
			this.config.createSection("rankList");
		}
	}
	
	
	/*--------------------------------------------------------------------------------
	 * Get rank config method.
	 * */
	public FileConfiguration getConfig() {
		return this.config;
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Save config method. 
	 * Call everytime a change is made to the rank config file.
	 * */
	public void save() {
		try {
			this.config.save(configFile);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Set new <value> at the <path> in rank config file.
	 * */
	public void setPath(String path, Object value) {
		this.config.set(path, value);
		save();
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Get value from given path.
	 * Returns any object the path points to.
	 * */
	@SuppressWarnings("unchecked")
	public <T> T getFromPath(String path) {
		return (T)this.config.get(path);
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Return configuration section to see if exists.
	 *
	public ConfigurationSection getConfigSection(String path) {
		return config.getConfigurationSection(path);
	}*/
	public boolean configSectionExists(String path) {
		if(this.config.get(path) == null) {
			return false;
		}
		
		return true;
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Create new config section for new players.
	 * */
	public void createNewRank(Player player) {
		this.config.createSection("rankList."+player.getUniqueId().toString());
		setPath("rankList."+player.getUniqueId().toString(), RankType.PLAYER.getPower());
		save();
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Set new rank to already existing players.
	 * */
	public void setRank(Player player, RankType rank) {
		setPath("rankList."+player.getUniqueId().toString(), rank.getPower());
		save();
	}
	
	
	
	/*--------------------------------------------------------------------------------
	 * Get rank power/id based on given @player.
	 * */
	public int getRankID(Player player) {
		return getFromPath("rankList."+player.getUniqueId().toString());
	}
	
	
	
	
	public static RankConfig getInstance() {
		return instance;
	}
	public Plugin getPlugin() {
		return this.plugin;
	}
}
