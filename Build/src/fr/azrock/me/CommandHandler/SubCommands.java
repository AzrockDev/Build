package fr.azrock.me.CommandHandler;

import org.bukkit.entity.Player;

public abstract class SubCommands {

	public abstract void onCommand(Player player, String[] args);

	public abstract String name();
	
}