package fr.azrock.me.Commands.RankCmds;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.azrock.me.Commands.CommandManager;
import fr.azrock.me.Commands.SubCommands;
import fr.azrock.me.Commands.RankCmds.SubCommands.ListCmd;
import fr.azrock.me.Commands.RankCmds.SubCommands.SetCmd;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;

public class RankCommands extends CommandManager {
	
	public RankCommands() {
		super("Rank", 1);
	}
	
	public void setupCommands() {
		sCommands.add(new ListCmd());
		sCommands.add(new SetCmd());
	}
	
	private ArrayList<SubCommands> sCommands = new ArrayList<SubCommands>();

	
	public void execute(final CommandSender sender, String[] args) {
		Player player = (Player)sender;
		
		if(args.length == 0) {
			
			MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /rank <rank>/list/<player> <rank>");
			
			
		/*	player.sendMessage(Alert.MESSAGE.getColor()+Alert.SEPARATOR.getColor());
			for(RankType rt : RankType.values()) {
				MessageUtils.getInstance().alert(player, Alert.INFO, "- "+rt.getColor()+rt.getName());
			}
			player.sendMessage(Alert.MESSAGE.getColor()+Alert.SEPARATOR.getColor());	*/
			
			return;
		}else {
			
			SubCommands cmdArg = getSC(args[0]);
			
			//Check if argument exists
			if(cmdArg == null) {
				player.sendMessage("§cCette commande n'existe pas!");
				return;
			}
			
			ArrayList<String> al = new ArrayList<String>();		//Declare new ArrayList al
			al.addAll(Arrays.asList(args));  					//Initialize new arrayList al with the args array's content.
			al.remove(0);										//Remove first argument (eg. /parcours add Test, remove 'add' argument)
			args = al.toArray(new String[al.size()]);			//Set new args to the modified ArrayList al in order to compensate for seperate arg classes.

			try {
				cmdArg.onCommand(player, args);
			}catch(Exception e) { player.sendMessage("§cUne erreur s'est produite!") ;e.printStackTrace(); }
			
		}
	}
	
	
	private SubCommands getSC(String args) {
		for(SubCommands sc : sCommands) {
			if(sc.name().equalsIgnoreCase(args)) return sc;
		}
		return null;
	}

}
