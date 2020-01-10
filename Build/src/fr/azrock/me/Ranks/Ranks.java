package fr.azrock.me.Ranks;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;


public class Ranks {

	public HashMap<UUID, Integer> rankMap = new HashMap<UUID, Integer>();
	
	
	public void updateRank(Player player) {
		
		if(!rankMap.containsKey(player.getUniqueId())) {
			
			int id = RankConfig.getInstance().getRankID(player);
			
			rankMap.put(player.getUniqueId(), id);
			updateRankStyle(player, id);
		}
	}
	
	public void setRank(Player player, RankType rank) {
		RankConfig.getInstance().setNewRank(player, rank);
		updateRankStyle(player, rank.getPower());
	}
	
	
	
	public void updateRankStyle(Player player, int rankId) {
		
		switch(rankId) {
		
		case 1:
			player.setPlayerListName(RankType.ADMIN.getRank()+player.getName());
			
		case 5:
			player.setPlayerListName(RankType.BUILDER.getRank()+player.getName());
			
		case 10:
			player.setPlayerListName(RankType.AMI.getRank()+player.getName());
			
		case 15:
			player.setPlayerListName(RankType.PLAYER.getColor()+player.getName());
		
		default:
			RankConfig.getInstance().setNewRank(player, RankType.PLAYER);
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
