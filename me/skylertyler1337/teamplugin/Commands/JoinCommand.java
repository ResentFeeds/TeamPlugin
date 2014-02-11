ackage me.skylertyler1337.teamplugin.Commands;

import me.skylertyler1337.teamplugin.TeamPlugin;
import me.skylertyler1337.teamplugin.Teams.Team;
import me.skylertyler1337.teamplugin.Teams.TeamType;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinCommand implements CommandExecutor {

    TeamPlugin plugin;

	public JoinCommand(TeamPlugin instance) {
		this.plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,
			String[] args) {
		if(label.equalsIgnoreCase("join")) {
		int i = 0;
		for(Player player : Bukkit.getOnlinePlayers()){
		  if(i < Bukkit.getOnlinePlayers().length/2){
			 //Add to Red Team!
			 Team.AddToTeam(TeamType.RED,player);
		  }else{
			 //Add to Blue Team!
			Team.AddToTeam(TeamType.BLUE, player);
		  }
		  i++;
		}
		
		}
		
		return true;
	}

}
