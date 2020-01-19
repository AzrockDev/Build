package fr.azrock.me.Warps;

import java.util.ArrayList;
import java.util.List;

import fr.azrock.me.ConfigurationFiles.Config;

public class WarpManager {

	private static ArrayList<Warp> warpList = new ArrayList<Warp>();
	
	private static Config config = Warp.getConfig();
	
	/*
	 * Loop through ranks in warpConfig & add to warpList
	 * Call method on enable.
	 * Call method once new warp has been added to config.
	 * 
	 * */
	public static void setupWarps() {
		
		clear();
		
		List<String> warps = config.getFromPath("ranks");
		
		
	}
	
	public static void addWarp(Warp warp) {
		warpList.add(warp);
	}
	
	public static void clear() {
		warpList.clear();
	}
	
	public static boolean warpExists(Warp warp) {
		return warpList.contains(warp);
	}
	
	public static ArrayList<Warp> getWarpList() {
		return warpList;
	}
}
