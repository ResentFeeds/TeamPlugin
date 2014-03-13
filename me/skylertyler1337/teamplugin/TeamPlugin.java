package me.skylertyler1337.teamplugin;

import me.skylertyler1337.teamplugin.Listeners.EntityDamageListener;
import me.skylertyler1337.teamplugin.Listeners.ObserverListener;
import me.skylertyler1337.teamplugin.Listeners.ChatListener;
import me.skylertyler1337.teamplugin.Listeners.PickTeamListener;
import me.skylertyler1337.teamplugin.Commands.JoinCommand;
import me.skylertyler1337.teamplugin.Commands.MyteamCommand;
import me.skylertyler1337.teamplugin.Teams.Team;

import org.bukkit.plugin.java.JavaPlugin;

public class TeamPlugin extends JavaPlugin {

	
	@Override
	public void onEnable() {
	System.out.println("[TeamPlugin] is Enabled!");
  //still working on this getServer().getPluginManager().registerEvents(new EntityDamageListener(this),  this);
	getServer().getPluginManager().registerEvents(new ObserverListener(this), this);
 //still working on this getServer().getPluginManager().registerEvents(new ChatListener(this), this);
	getServer().getPluginManager().registerEvents(new PickTeamListener(this), this);
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

