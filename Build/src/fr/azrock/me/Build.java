package fr.azrock.me;

import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.Commands.CommandManager;
import fr.azrock.me.Commands.RankCmds.RankCommands;
import fr.azrock.me.Ranks.RankConfig;
import fr.azrock.me.Utils.ListenersUtils;

public class Build extends JavaPlugin {

	private static JavaPlugin instance;
	
	
	public void onEnable() {
		instance = this;
		
		CommandManager.registerCommands(this);
		ListenersUtils.getInstance().registerListeners(this);
		
		RankConfig.getInstance().setupConfig(this);
		
		RankCommands rank = new RankCommands();
		rank.setupCommands();
		
	}
	
	
	
	
	public static JavaPlugin getPlugin() {
		return instance;
	}
}
