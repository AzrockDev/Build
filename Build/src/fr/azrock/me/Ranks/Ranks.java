package fr.azrock.me.Ranks;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;


public class Ranks {

	private static Map<UUID, RankType> rankMap = new HashMap<UUID, RankType>();

	/*
	 * Rank Update Method for a given <player>
	 * Call method everytime a player joins to set rank if existing or new rank.
	 * */
	public void updateRank(Player player) {

		final String RANK_PATH = "rankList."+player.getUniqueId().toString();
		final UUID uuid = player.getUniqueId();

		/*Remove player from rank map to update new.*/
		if(rankMap.containsKey(uuid))
			rankMap.remove(uuid);
		
		
		/*
		 *	Player shouldn't be in map at this point,
		 *	Thus update rank and add to map.
		 * 
		 * */
		if(!rankMap.containsKey(uuid)) {

			if(!RankConfig.getInstance().configSectionExists(RANK_PATH)) {
				RankConfig.getInstance().createNewRank(player);
			}

			
			int id = RankConfig.getInstance().getRankID(player);

			setPlayer(player, id);
			updateRankStyle(player, id);	
		}
	}

	
	
	/*
	 * Set rank param @player, @rank
	 * Set new rank in config + update rank
	 * 
	 * Get rank param @player
	 * Get rank from rankMap.
	 * 
	 * */
	public void setRank(Player player, RankType rank) {
		RankConfig.getInstance().setRank(player, rank);
		updateRank(player);
	}
	//------------
	public RankType getRank(Player player) {
		return rankMap.get(player.getUniqueId());
	}



	/*
	 * Update rank's style param @player @rankId/Power
	 * Updates player tab name following rank.
	 * 
	 * IMPORTANT (todo): Instead of switch()case, loop through existing ranks, match int to rankId, return matched rank, otherwise, return PLAYER.
	 * 
	 * */
	public void updateRankStyle(Player player, int rankId) {

		switch(rankId) {

		case 1:
			player.setPlayerListName(RankType.ADMIN.getRank()+player.getName());
			break;

		case 5:
			player.setPlayerListName(RankType.BUILDER.getRank()+player.getName());
			break;

		case 10:
			player.setPlayerListName(RankType.AMI.getRank()+player.getName());
			break;

		case 15:
			player.setPlayerListName(RankType.PLAYER.getColor()+player.getName());
			break;

		}
	}

	
	
	/*
	 * get rank from id, same as above method.
	 * */
	public RankType getRankFromId(int rankId) {
		switch(rankId) {
		case 1:
			return RankType.ADMIN;

		case 5:
			return RankType.BUILDER;

		case 10:
			return RankType.AMI;	
		}

		return RankType.PLAYER;
	}


	/*
	 * rankMap management methods.
	 * 
	 * */
	public void quitPlayer(Player player) {
		rankMap.remove(player.getUniqueId());
		return;
	}
	public void clearPlayers() {
		rankMap.clear();
	}
	public void setPlayer(Player player, int id) {
		UUID uuid = player.getUniqueId();
		RankType rank = getRankFromId(id);
		
		rankMap.put(uuid, rank);
	}
	
	
	//---- return instance. ----
	public static Ranks getInstance() {
		return new Ranks();
	}
}
