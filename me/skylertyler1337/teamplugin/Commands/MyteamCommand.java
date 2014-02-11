package me.skylertyler1337.teamplugin.Commands;

import me.skylertyler1337.teamplugin.TeamPlugin;
import me.skylertyler1337.teamplugin.Teams.Team;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyteamCommand implements CommandExecutor {

	TeamPlugin plugin;

	public MyteamCommand(TeamPlugin instance) {
		this.plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if(label.equalsIgnoreCase("myteam")) {
		  sender.sendMessage(ChatColor.GRAY+Team.getTeamType(((Player)sender)).name()); 
			
		    }
			return true;
		}

	
   }
