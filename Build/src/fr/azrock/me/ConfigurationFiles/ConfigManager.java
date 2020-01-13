package fr.azrock.me.ConfigurationFiles;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;


public abstract class ConfigManager {

	private FileConfiguration config;
	private File configFile;
	
	private String fileName;
	private String firstHeadingName;
	
	
	public ConfigManager(String fileName, String firstHeadingName) {
		this.fileName = fileName;
		this.firstHeadingName = firstHeadingName;
	}
	
	
	protected void setup(Plugin plugin) {
		
		boolean noHeading = false;
		
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		configFile = new File(plugin.getDataFolder(), this.fileName);
		
		
		if(!configFile.exists()) {
			try {
				configFile.createNewFile();
				noHeading = true;
			}catch(Exception e) { e.printStackTrace(); }
		}
		
		this.config = YamlConfiguration.loadConfiguration(configFile);
		
		
		if(noHeading) {
			this.config.createSection(this.firstHeadingName);
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
	 */
	public boolean configSectionExists(String path) {
		if(this.config.get(path) == null) {
			return false;
		}
		
		return true;
	}
}
