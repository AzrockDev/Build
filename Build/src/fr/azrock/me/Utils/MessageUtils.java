package fr.azrock.me.Utils;

import org.bukkit.entity.Player;

public class MessageUtils {
	
	
	public void alert(Player player, Alert alert, String msg) {
		player.sendMessage(alert.toString()+msg);
	}
	
	public void alert(Player player, Alert alert) {
		player.sendMessage(alert.toString());
	}
	
	
	
	public boolean hasCorrectName(String s) {
		if(s == null) {
			return false;
		}
		for(int i=0; i<s.length(); i++) {
			if(Character.isLetterOrDigit(s.charAt(i)) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * =============================================
	 * */
	public static MessageUtils getInstance() {
		return new MessageUtils();
	}
}