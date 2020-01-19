package fr.azrock.me.CommandHandler;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azrock.me.Ranks.Ranks;
import fr.azrock.me.Ranks.Commands.RankCommand;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;
import fr.azrock.me.Warps.Commands.WarpCommand;

public abstract class CommandManager implements CommandExecutor {

	public abstract void execute(CommandSender sender, String[] args);
	
	
	private final String command;
	private final int power;
	private static JavaPlugin plugin;
	

	public CommandManager(String command, int power) {
		this.command = command;
		this.power = power;

		plugin.getCommand(command).setExecutor(this);
	}
	
	public String getCommandName() {
		return this.command;
	}

	

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player)sender;
		
		if(!(cmd.getLabel().equalsIgnoreCase(command))) return false;

		if(Ranks.getInstance().getRank(player).getPower() > power) {
			MessageUtils.getInstance().alert(player, Alert.UNKNOWN_COMMAND);
			return false;
		}

		if(!(sender instanceof Player)) return false;


		execute(sender, args);
		return true;
	}


	
	public static void registerCommands(JavaPlugin pl) {
		plugin = pl;
		new RankCommand();
		new WarpCommand();
	}
}