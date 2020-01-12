package fr.azrock.me.Commands.Cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.azrock.me.Commands.CommandManager;

public class HelpCommand extends CommandManager {

	public HelpCommand() {
		super("Help", 100);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		Player player = (Player)sender;
		
		player.sendMessage("§a----- §eHelp §a-----");
		return;
		
	}

}
