package fr.azrock.me.Warps.Commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.azrock.me.CommandHandler.CommandManager;
import fr.azrock.me.CommandHandler.SubCommands;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;
import fr.azrock.me.Warps.Commands.SubCommands.WarpCreate;
import fr.azrock.me.Warps.Commands.SubCommands.WarpList;
import fr.azrock.me.Warps.Commands.SubCommands.WarpRemove;
import fr.azrock.me.Warps.Commands.SubCommands.WarpTp;

public class WarpCommand extends CommandManager {

	private static ArrayList<SubCommands> sCommands = new ArrayList<SubCommands>();
	
	
	
	public WarpCommand() {
		super("warp", 5);
	}

	
	public void registerSubCommands() {
		sCommands.add(new WarpCreate());
		sCommands.add(new WarpRemove());
		sCommands.add(new WarpList());
		sCommands.add(new WarpTp());
	}
	
	
	public void execute(CommandSender sender, String[] args) {
		Player player = (Player)sender;

		if(args.length == 0) {

			MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /warp list/create/remove/tp <warp>");
			return;


		}else {

			SubCommands cmdArg = getSC(args[0]);

			//Check if argument exists
			if(cmdArg == null) {
				MessageUtils.getInstance().alert(player, Alert.UNKNOWN_COMMAND);
				return;
			}

			ArrayList<String> al = new ArrayList<String>();		//Declare new ArrayList al
			al.addAll(Arrays.asList(args));  					//Initialize new arrayList al with the args array's content.
			al.remove(0);										//Remove first argument (eg. /parcours add Test, remove 'add' argument)
			args = al.toArray(new String[al.size()]);			//Set new args to the modified ArrayList al in order to compensate for seperate arg classes.

			try {
				cmdArg.onCommand(player, args);
			}catch(Exception e) { player.sendMessage("§cUne erreur s'est produite!"); e.printStackTrace(); }

		}
	}
	
	
	public SubCommands getSC(String args) {
		for(SubCommands sc : sCommands) {
			if(sc.name().equalsIgnoreCase(args)) return sc;
		}
		
		return null;
	}

}
