package me.skylertyler1337.teamplugin.Commands;

import org.bukkit.command.CommandExecutor;


public class JoinCommand implements CommandExecutor{


	public TeamPlugin plugin;

	public ArcherCommand(TeamPlugin instance) {
		return;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandlabel
			,String[] args) {
		Player p = (Player) sender;
		if(commandlabel.equalsIgnoreCase("join"));

}
