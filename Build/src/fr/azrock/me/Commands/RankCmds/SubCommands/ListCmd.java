package fr.azrock.me.Commands.RankCmds.SubCommands;

import org.bukkit.entity.Player;

import fr.azrock.me.Commands.SubCommands;
import fr.azrock.me.Ranks.RankType;

public class ListCmd extends SubCommands {

	@Override
	public void onCommand(Player player, String[] args) {
		
		player.sendMessage("�a----- �eGrades �a-----");
		for(RankType rank : RankType.values()) {
			player.sendMessage("�e- "+rank.getColor()+rank.getName());
		}
	}

	@Override
	public String name() {
		return "list";
	}

}