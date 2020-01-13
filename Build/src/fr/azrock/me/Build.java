package fr.azrock.me;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.Commands.CommandManager;
import fr.azrock.me.Ranks.Commands.RankCommand;
import fr.azrock.me.Ranks.RankManager.RankConfig;
import fr.azrock.me.Utils.ListenersUtils;
import fr.azrock.me.Warps.Commands.WarpCommand;

public class Build extends JavaPlugin {

	private static JavaPlugin instance;
	
	
	public void onEnable() {
		instance = this;
		
		CommandManager.registerCommands(this);
		ListenersUtils.getInstance().registerListeners(this);
		
		RankConfig.getInstance().setupConfig(this);
		RankCommand rank = new RankCommand();
		rank.setupCommands();
		
		WarpCommand warp = new WarpCommand();
		warp.registerCommands();
		
		
	}
	
	
	
	
	public static JavaPlugin getPlugin() {
		return instance;
	}
}
