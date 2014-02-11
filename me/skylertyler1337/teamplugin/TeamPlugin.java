package me.skylertyler1337.teamplugin;

import me.skylertyler1337.teamplugin.Commands.JoinCommand;
import me.skylertyler1337.teamplugin.Commands.MyteamCommand;
import me.skylertyler1337.teamplugin.Teams.Team;

import org.bukkit.plugin.java.JavaPlugin;

public class TeamPlugin extends JavaPlugin {

	
	@Override
	public void onEnable() {
	System.out.println("[TeamPlugin] is Enabled!");
	getCommand("join").setExecutor(new JoinCommand(this));
	getCommand("myteam").setExecutor(new MyteamCommand(this));
	Team.ClearTeams();
	}
	
	@Override
	public void onDisable() {
	System.out.println("[TeamPlugin] is Disabled!");
	Team.ClearTeams();
	}
	
}

