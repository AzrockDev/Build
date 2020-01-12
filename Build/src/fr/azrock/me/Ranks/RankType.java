package fr.azrock.me.Ranks;

public enum RankType {

	ADMIN("Admin", "§c", 1), BUILDER("Builder", "§a", 5), AMI("Ami", "§e", 10), PLAYER("", "§7", 15);
	
	
	public String rank;
	public String name;
	public String color;
	public int power;
	
	RankType(String name, String color, int power) {
		this.rank = color+"["+name+"] ";
		this.name = name;
		this.color = color;
		this.power = power;
	}
	
	
	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public String getRank() {
		return this.rank;
	}
	public int getPower() {
		return this.power;
	}
}
