package fr.azrock.me.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.Build;
import fr.azrock.me.Commands.RankCmds.RankCommands;

public abstract class CommandManager implements CommandExecutor {

	public abstract void execute(CommandSender sender, String[] args);
	
	
	private final String command;
	private final int power;
	private static JavaPlugin plugin = Build.getPlugin();

	public CommandManager(String command, int power) {
		this.command = command;
		this.power = power;

		plugin.getCommand(command).setExecutor(this);
	}


	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if(!(cmd.getLabel().equalsIgnoreCase(command))) return false;

		//if(!(sender.hasPermission(permision))) return false;

		if(!(sender instanceof Player)) return false;


		execute(sender, args);
		return true;
	}


	public static void registerCommands(JavaPlugin pl) {
		pl = plugin;
		new RankCommands();
	}

}
