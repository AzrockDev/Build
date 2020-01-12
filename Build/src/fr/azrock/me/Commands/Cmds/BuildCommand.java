package fr.azrock.me.Commands.Cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.azrock.me.Commands.CommandManager;
import fr.azrock.me.Ranks.Ranks;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;

public class BuildCommand extends CommandManager {

	public BuildCommand() {
		super("build", 10);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		Player player = (Player)sender;
		
		if(args.length == 0) {
			
			MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /build reload");
			return;
			
		}else {
			
			if(args[0].contentEquals("reload")) {
				
				Ranks.getInstance().updateRank(player);
				MessageUtils.getInstance().alert(player, Alert.INFO, "Tu as bien reload ton grade!");
				return;
				
			}else {
				
				MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Cette commande n'existe pas!");
				return;
			}
			
		}
		
	}

}
