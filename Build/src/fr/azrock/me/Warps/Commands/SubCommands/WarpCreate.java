package fr.azrock.me.Warps.Commands.SubCommands;

import org.bukkit.entity.Player;

import fr.azrock.me.Commands.SubCommands;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;

public class WarpCreate extends SubCommands {

	public void onCommand(Player player, String[] args) {
		if(args.length == 0) {
			
			MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /warp create <warpName>");
			return;
			
		}else {
			
			String warpName = args[0];
			
			boolean correctName = MessageUtils.getInstance().hasCorrectName(warpName);
			
			if(!correctName) {
				MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Les noms de warp peuvent uniquement contenir chiffres et/ou lettres.");
				return;
			}
			
			//Warp newWarp = new Warp(warpName, player.getLocation(), RankType.AMI.getPower());
			
			
		}
	}

	
	
	public String name() {
		return "create";
	}
}