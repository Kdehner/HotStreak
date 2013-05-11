package net.kdehner.HotStreak;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HotStreakCommandExecutor implements CommandExecutor {
	
	//prefix
	private String prefix = HotStreakManager.getPrefix();
	
	//onCommand()
	//Called when a command is run.
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] arg) {
		
		if (cmd.getName().equalsIgnoreCase("hotstreak") || cmd.getName().equalsIgnoreCase("hs")) {
			
			//If command sent from console
			if (!(sender instanceof Player)) {
				
				//Notify how to use console command
				if (arg.length != 1) {
					sender.sendMessage("Console usage: /"+cmd.getName()+" <username>");						
					}
				
				//Get & Display hot streak streak
				else {
					int streak = HotStreakManager.get(arg[0]);
					sender.sendMessage(prefix+arg[0]+" is on a hot streak of "+streak);
				}
				return true;
			}
			
			//Send hotstreak info to player.
			int streak = HotStreakManager.get(sender.getName());
			sender.sendMessage(prefix+"Your hot streak is "+streak);
		}
		return true;
	}
}
