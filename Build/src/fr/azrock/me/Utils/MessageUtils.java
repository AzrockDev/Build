package fr.azrock.me.Utils;

import org.bukkit.entity.Player;

public class MessageUtils {
	
	
	public void alert(Player player, Alert alert, String msg) {
		player.sendMessage(alert.getColor()+msg);
	}
	
	
	
	
	public static MessageUtils getInstance() {
		return new MessageUtils();
	}
}