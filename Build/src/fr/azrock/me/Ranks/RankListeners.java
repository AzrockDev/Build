package fr.azrock.me.Ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class RankListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if(!RankConfig.getInstance().hasConfigSection(player)) {
			RankConfig.getInstance().createNewPlayerFile(player);
		}
		
		Ranks.getInstance().updateRank(player);
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		int rankId = RankConfig.getInstance().getRankID(player);
		RankType rank = Ranks.getInstance().getRankFromId(rankId);
		
		if(rankId == 15) {
			event.setFormat(RankType.PLAYER.getColor()+player.getName()+" : "+event.getMessage());
		}else {
			event.setFormat(rank.getRank()+player.getName()+" §f: "+event.getMessage());
		}
	}
	
	
	
	
}
