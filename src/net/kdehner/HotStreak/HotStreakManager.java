package net.kdehner.HotStreak;

import org.bukkit.configuration.file.FileConfiguration;

public class HotStreakManager {
	
	//Variables for the main
	private static HotStreakMain plugin;
	private static HotStreakConfigManager cfm;
	private static FileConfiguration config;
	private static FileConfiguration pdata;
	
	//create()
	//Set the main reference and configuration
	public static void create(HotStreakMain pl) {
		
		plugin = pl;
		config = plugin.getConfig();
		pdata = cfm.loadConfig("PlayerData.yml");
		
		
	}
	
	//resetStreak()
	//Resets a players hotstreak
	public static void resetStreak(String player) {
		pdata.set("PlayerStreaks."+player, 0);
	}
	
	//add()
	//Add a kill to a player
	public static void add(String player) {
		int Streak = pdata.getInt("PlayerStreaks."+player) + 1;
		pdata.set("PlayerStreaks."+player, Streak);
		cfm.SaveConfig("PlayerData.yml", pdata);
	}
	
	//get()
	//Get a player's killstreak
	public static int get(String player) {
		if (config.get("PlayerStreaks."+player) == null) {
			return 0;
		}
		return config.getInt("PlayerStreaks."+player);
	}

}
