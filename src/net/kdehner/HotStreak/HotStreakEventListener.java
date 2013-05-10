package net.kdehner.HotStreak;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class HotStreakEventListener implements Listener {
	
	//Prefix for messages
	private String prefix = HotStreakManager.getPrefix();
	
	//variables for plguin
	private HotStreakMain plugin;
	private HotStreakConfigManager cfm;
	private FileConfiguration config;
	private FileConfiguration pdata;
	
	//HotStreakEventListener()
	//Constructor
	
	HotStreakEventListener(HotStreakMain pl) {
		plugin = pl;
		config = plugin.getConfig();
		pdata = cfm.loadConfig("PlayerData.yml");
	}
	
	//onQuit()
	//Called when player disconnects from the server
	public void onQuit(PlayerQuitEvent pQuit) {
		if (config.getBoolean("HotStreak.resetondisconnect")) {
			String uname = pQuit.getPlayer().getName();
			HotStreakManager.resetStreak(uname);			
		}
	}
	
	//onDeath()
	//Called when player dies
	@EventHandler
	public void onDeath(PlayerDeathEvent pDeath) {
		
	}

}
