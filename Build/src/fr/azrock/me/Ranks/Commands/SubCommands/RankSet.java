package fr.azrock.me.Ranks.Commands.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.azrock.me.Commands.SubCommands;
import fr.azrock.me.Ranks.RankType;
import fr.azrock.me.Ranks.Ranks;
import fr.azrock.me.Utils.Alert;
import fr.azrock.me.Utils.MessageUtils;

public class RankSet extends SubCommands {

	@Override
	public void onCommand(Player player, String[] args) {

		if(args.length == 0) {

			// /rank set [args...] = 0
			MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Essaie avec /rank set (<player>) <rank>");
			return;

		}else {

			// Initialize rank as null
			RankType rank = null;


			/* Loop through all existing ranks by their names,
			 * if current rank selected matches entered args[0],
			 * set rank to this new rank and break loop.*/
			for(RankType rt : RankType.values()) {
				if(rt.getName().equalsIgnoreCase(args[0])) {
					rank = rt;
					break;
				}
			}


			/*  Check if rank is still null, if so, the args[0] doesn't match with existing rank, thus it doesn't exist */
			if(rank == null) {
				MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Ce grade n'existe pas!");
				return;
			}


			/* After checking that rank existed, check if more args or not,
			 * if not: Set rank to player.
			 * else: Check for other player. */
			if(args.length == 1) {

				player.sendMessage("§aTu t'es mis le grade "+rank.getRank());
				Ranks.getInstance().setRank(player, rank);
				return;
				
			}else {

				Player target = Bukkit.getPlayer(args[1]);

				if(target == null) {
					MessageUtils.getInstance().alert(player, Alert.CRITICAL, "Ce joueur n'est pas connecté!");
					return;
				}

				player.sendMessage("§aTu as mis le grade "+rank.getRank()+"§aà "+target.getName()+".");
				Ranks.getInstance().setRank(target, rank);
				return;

			}


		}
	}

	@Override
	public String name() {
		return "set";
	}

}