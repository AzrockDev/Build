package fr.azrock.me.Utils;

public enum Alert {
	MESSAGE("§a"), INFO("§e"), CRITICAL("§c"), SEPARATOR("------------");


	private String characters;

	Alert(String characters) {
		this.characters = characters;
	}
	public String getColor() {
		return this.characters;
	}
}
