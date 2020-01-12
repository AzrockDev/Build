package fr.azrock.me.Ranks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		Ranks.getInstance().updateRank(player);
		
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		
		RankType rank = Ranks.getInstance().getRank(player);
		int rankId = rank.getPower();
		
		if(rankId == 15) {
			event.setFormat(RankType.PLAYER.getColor()+player.getName()+" : "+event.getMessage());
		}else {
			event.setFormat(rank.getRank()+player.getName()+" §f: "+event.getMessage());
		}
	}
	
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Ranks.getInstance().quitPlayer(event.getPlayer());
	}
}