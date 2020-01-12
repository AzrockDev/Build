package fr.azrock.me.Ranks;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;


public class Ranks {

	public HashMap<UUID, Integer> rankMap = new HashMap<UUID, Integer>();
	
	/*
	 * Rank Update Method for a given <player>
	 * Call method everytime a player joins to set rank if existing or new rank.
	 * */
	public void updateRank(Player player) {
		
		final String RANK_PATH = "rankList."+player.getUniqueId().toString();
		
		
		if(!rankMap.containsKey(player.getUniqueId())) {
			
			if(!RankConfig.getInstance().configSectionExists(RANK_PATH)) {
				RankConfig.getInstance().createNewRank(player);
				
				int id = RankConfig.getInstance().getFromPath(RANK_PATH);
				rankMap.put(player.getUniqueId(), id);
				updateRankStyle(player, id);
				return;
				
				
			}else {
				
				int id = RankConfig.getInstance().getFromPath(RANK_PATH);
				
				rankMap.put(player.getUniqueId(), id);
				updateRankStyle(player, id);
				return;
			}
		}
	}
	
	public void setRank(Player player, RankType rank) {
		RankConfig.getInstance().setRank(player, rank);
		rankMap.put(player.getUniqueId(), rank.getPower());
		updateRankStyle(player, rank.getPower());
	} 
	
	public int getRankPower(Player player) {
		int id = rankMap.get(player.getUniqueId());
		return id;
	}
	
	/*public boolean rankExists(RankType rank) {
		if()
	}*/
	
	
	
	public void updateRankStyle(Player player, int rankId) {
		
		switch(rankId) {
		
		case 1:
			player.setPlayerListName(RankType.ADMIN.getRank()+" "+player.getName());
			
		case 5:
			player.setPlayerListName(RankType.BUILDER.getRank()+" "+player.getName());
			
		case 10:
			player.setPlayerListName(RankType.AMI.getRank()+" "+player.getName());
			
		case 15:
			player.setPlayerListName(RankType.PLAYER.getColor()+player.getName());
		
		default:
			player.setPlayerListName(RankType.PLAYER.getColor()+player.getName());
			
		}
	}
	
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
	
	
	public static Ranks getInstance() {
		return new Ranks();
	}
}
