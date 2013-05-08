package net.kdehner.HotStreak;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class HotStreakMain extends JavaPlugin {
	
	//Configfiles
	public FileConfiguration config;
	public FileConfiguration playerdata;
	
	//create pointer for config access
	public HotStreakConfigManager cfm = new HotStreakConfigManager(this);
	
	public void onEnable() {
		
		//Display plugin enabled message
		getLogger().info(getDescription().getFullName()+" enabled!");
		
		//Save default config file
		this.saveDefaultConfig();
		config = this.getConfig();
		
		//Save default playerdata
		cfm.saveDefaultConfig("PlayerData.yml");
		playerdata = cfm.loadConfig("PlayerData.yml");
		
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
