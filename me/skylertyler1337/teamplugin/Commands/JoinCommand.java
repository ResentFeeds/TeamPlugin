package me.skylertyler1337.teamplugin.Commands;

import me.skylertyler1337.teamplugin.TeamPlugin;
import me.skylertyler1337.teamplugin.Tools;
import me.skylertyler1337.teamplugin.Teams.Team;
import me.skylertyler1337.teamplugin.Teams.TeamType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class JoinCommand implements CommandExecutor {
    TeamPlugin plugin;
   	public JoinCommand(TeamPlugin instance) {
   		this.plugin = instance;
   	}
   	@Override
   	public boolean onCommand(CommandSender sender, Command command, String label,
   			String[] args) {
   	   Player player = (Player) sender; 
   		if(label.equalsIgnoreCase("join")) {
   			if(args.length==1){
   				//Add to Observers! 
   				if(args[0].equalsIgnoreCase("obs") || args[0].equalsIgnoreCase("o")){
                  Team.AddToTeam(TeamType.Observers, player);
                  Team.obsteam.remove(player.getName());
                  Team.obsteam.add(player.getName());
                  player.sendMessage(ChatColor.GRAY+"You Joined the "+ChatColor.AQUA+"Observers");
                  Tools.hidePlayer(player);
                  return false;
   				}
   			}
   		  int i = 0;
  		  if(i < Bukkit.getOnlinePlayers().length/2){  
   			 //Add to Red Team!
   		    Team.AddToTeam(TeamType.Red,player);
            Team.redteam.add(player.getName());
            Team.redteam.remove(player.getName());
            //Armor
            ItemStack leatherhelmet = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta leatherhelmetmeta = (LeatherArmorMeta) leatherhelmet.getItemMeta();
            leatherhelmetmeta.setColor(Color.RED);
            leatherhelmet.setItemMeta(leatherhelmetmeta);
            
            ItemStack leatherchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta leatherchestplatemeta = (LeatherArmorMeta) leatherchestplate.getItemMeta();
            leatherchestplatemeta.setColor(Color.RED);
            leatherchestplate.setItemMeta(leatherhelmetmeta);
            
            ItemStack leatherlegging = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leatherleggingmeta = (LeatherArmorMeta) leatherlegging.getItemMeta();
            leatherleggingmeta.setColor(Color.RED);
            leatherlegging.setItemMeta(leatherleggingmeta);
            
            ItemStack leatherboot = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta leatherbootmeta = (LeatherArmorMeta) leatherboot.getItemMeta();
            leatherbootmeta.setColor(Color.RED);
            leatherboot.setItemMeta(leatherbootmeta);
            //adding to inventory
            PlayerInventory pi = player.getInventory();
            pi.setHelmet(leatherhelmet);
            pi.setChestplate(leatherchestplate);
            pi.setLeggings(leatherlegging);
            pi.setBoots(leatherboot);
            //message
            player.sendMessage(ChatColor.GRAY+"You Joined the "+ChatColor.RED+"Red Team");
   			Tools.showPlayer(player);
   		  }else{
   			//Add to Blue Team!
     		  Team.AddToTeam(TeamType.Blue, player);
     		  Team.blueteam.remove(player.getName());
              Team.blueteam.add(player.getName());
              //Armor
              ItemStack leatherhelmet = new ItemStack(Material.LEATHER_HELMET);
              LeatherArmorMeta leatherhelmetmeta = (LeatherArmorMeta) leatherhelmet.getItemMeta();
              leatherhelmetmeta.setColor(Color.BLUE);
              leatherhelmet.setItemMeta(leatherhelmetmeta);
              
              ItemStack leatherchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
              LeatherArmorMeta leatherchestplatemeta = (LeatherArmorMeta) leatherchestplate.getItemMeta();
              leatherchestplatemeta.setColor(Color.BLUE);
              leatherchestplate.setItemMeta(leatherhelmetmeta);
              
              ItemStack leatherlegging = new ItemStack(Material.LEATHER_LEGGINGS);
              LeatherArmorMeta leatherleggingmeta = (LeatherArmorMeta) leatherlegging.getItemMeta();
              leatherleggingmeta.setColor(Color.BLUE);
              leatherlegging.setItemMeta(leatherleggingmeta);
              
              ItemStack leatherboot = new ItemStack(Material.LEATHER_BOOTS);
              LeatherArmorMeta leatherbootmeta = (LeatherArmorMeta) leatherboot.getItemMeta();
              leatherbootmeta.setColor(Color.BLUE);
              leatherboot.setItemMeta(leatherbootmeta);
              //adding to inventory
              PlayerInventory pi = player.getInventory();
              pi.setHelmet(leatherhelmet);
              pi.setChestplate(leatherchestplate);
              pi.setLeggings(leatherlegging);
              pi.setBoots(leatherboot);
              //message
              player.sendMessage(ChatColor.GRAY+"You Joined the "+ChatColor.BLUE+"Blue Team");
              Tools.showPlayer(player);
   		    }
  		  i++;
  		  }
  return false;
   }
}

