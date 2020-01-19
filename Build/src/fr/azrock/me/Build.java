package fr.azrock.me;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.CommandHandler.CommandManager;
import fr.azrock.me.ConfigurationFiles.ConfigManager;
import fr.azrock.me.Ranks.Commands.RankCommand;
import fr.azrock.me.Ranks.RankManager.RankConfig;
import fr.azrock.me.Utils.ListenersUtils;
import fr.azrock.me.Warps.Commands.WarpCommand;

public class Build extends JavaPlugin {

	private static JavaPlugin instance;
	
	
	public void onEnable() {
		instance = this;
		
		ConfigManager.checkDataFolder(this);
		ConfigManager.declareConfigs(this);
		
		CommandManager.registerCommands(this);
		
		ListenersUtils.getInstance().registerListeners(this);
		
		RankConfig.getInstance().setupConfig(this);
		
		
		/*-----------------------------------------------
		 * Register Main command's SubCommands
		 * Not required for individual commands.
		 * */
		//--- Ranks --
		RankCommand rank = new RankCommand();
		rank.registerSubCommands();
		//--- Warps --
		WarpCommand warp = new WarpCommand();
		warp.registerSubCommands();
		//--- Moderation --
		
		/* -------------------------------------------------- */
	}
	
	
	
	
	public static JavaPlugin getPlugin() {
		return instance;
	}
}
