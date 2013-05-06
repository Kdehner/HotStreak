package net.kdehner.HotStreak;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class HotStreakConfigManager {
	
	//Variables for plugin & logger
	private final HotStreakMain plugin;
	private Logger log;
	
	//Enables multiple yaml config files
	public HotStreakConfigManager(HotStreakMain instance) {
		plugin = instance;
		log = plugin.getLogger();
	}
	
	//Loads the secondary config file.
	public FileConfiguration loadConfig(String fileName) {
		File file = new File(plugin.getDataFolder(), fileName);
		FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
		
		//Looks for defaults in the jar
		InputStream defConfigStream = plugin.getResource(fileName);
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			fileConfiguration.setDefaults(defConfig);
		}
		return fileConfiguration;
	}

}
