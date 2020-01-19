package fr.azrock.me.ConfigurationFiles;

public class Config extends ConfigManager {
	
	public String fileName;
	public String firstHeading;

	public Config(String fileName, String firstHeadingName) {
		super(fileName, firstHeadingName);
		
		this.fileName = fileName;
		this.firstHeading = firstHeadingName;
	}
}
