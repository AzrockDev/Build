package fr.azrock.me.Utils;

import org.bukkit.entity.Player;

public class MessageUtils {
	
	
	public void alert(Player player, Alert alert, String msg) {
		player.sendMessage(alert.toString()+msg);
	}
	
	public void alert(Player player, Alert alert) {
		player.sendMessage(alert.toString());
	}
	
	
	
	public static MessageUtils getInstance() {
		return new MessageUtils();
	}
}