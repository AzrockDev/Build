package fr.azrock.me.Utils;

public enum Alert {
	MESSAGE("§a"), INFO("§e"), CRITICAL("§c"), SEPARATOR("------------"), UNKNOWN_COMMAND("Commande inconnue. Fait /help pour obtenir de l'aide.");


	private String characters;

	Alert(String characters) {
		this.characters = characters;
	}
	public String toString() {
		return this.characters;
	}
}
