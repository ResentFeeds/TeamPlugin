package me.skylertyler1337.teamplugin.Teams;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

    public class Team {
	
	 public static List<String> redteam = new ArrayList<String>();
	 public static List<String> blueteam = new ArrayList<String>();
	 public static List<String>  obsteam = new ArrayList<String>();	
	
     public static void AddToTeam(TeamType type, Player player){
	 if(IsInTeam(player)){
		 player.sendMessage(ChatColor.GRAY+"You are already in a team!");
		 return;
	 }
	  switch(type){
	  case RED:
	      redteam.add(player.getName());
	      break;
	  case BLUE:
		  blueteam.add(player.getName());
		  break;
	  case Observers:
		  obsteam.add(player.getName());
		  break;
	     }
	  player.sendMessage(ChatColor.GRAY+"You joined the " + type.name() + "Team!");
		  
	  }
  
    public static boolean IsInTeam(Player player){
	return  redteam.contains(player.getName()) || blueteam.contains(player.getName()) 
			|| obsteam.contains(player.getName());
  }
 
     public static void ClearTeams(){
	 redteam.clear();
	 blueteam.clear();
	 
 }
 
    public List<String> GetRedTeam(){
	return redteam;	 
 }
 
     public List<String> GetBlueTeam(){
	 return blueteam;
 }
    public List<String> GetObsTeam(){
     return obsteam;
}
  public static List<String> getAllPlayersInTeam(){
	List<String> combinedteams = new ArrayList<String>();
	combinedteams.addAll(redteam);
	combinedteams.addAll(blueteam);
	return combinedteams;
   
 }


     public static TeamType getTeamType(Player player){
	if(!IsInTeam(player))
		return null;
	return(redteam.contains(player.getName()) ? 
			TeamType.RED : TeamType.BLUE);
	
	}
}

