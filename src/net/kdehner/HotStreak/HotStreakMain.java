package net.kdehner.HotStreak;

import org.bukkit.plugin.java.JavaPlugin;

public class HotStreakMain extends JavaPlugin {
	
	public void onEnable() {
		
		//Display plugin enabled message
		getLogger().info(getDescription().getFullName()+" enabled!");
		
		//Save default config file
		saveDefaultConfig();
		
		//Configure the HotStreakManager
		HotStreakManager.create(this);
		
		//Setting Command Executor
		getCommand("hotstreak").setExecutor(new HotStreakCommandExecutor());
		
		//Register HotStreakEventListener
		getServer().getPluginManager().registerEvents(new HotStreakEventListener(this), this);
	}
	
	public void onDisable() {
		
		//Display plugin disabled message
		getLogger().info(getDescription().getFullName()+" disabled!");
	}

}
