package me.skylertyler1337.teamplugin.Listeners;

import me.skylertyler1337.teamplugin.TeamPlugin;
import me.skylertyler1337.teamplugin.Teams.Team;
import me.skylertyler1337.teamplugin.Teams.TeamType;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PickTeamListener implements Listener {
	
	public TeamPlugin TeamPlugin;

	public PickTeamListener(TeamPlugin teamPlugin) {
		TeamPlugin = teamPlugin; 
	}

	private void teleportInworld(Player player ,int x,int y, int z){
		player.teleport(new Location(player.getWorld(),x,y,z));
	}

	private void openGUI(Player player){
     Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD+"Team Selector");
        //join red with the Inventory GUI!
		ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta redteamMeta = redstone.getItemMeta();
		
		//join blue with the Inventory GUI!
		ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta blueteamMeta = lapis.getItemMeta();
		
        //join random with the Inventory GUI!
		ItemStack netherstar = new ItemStack(Material.NETHER_STAR);
		ItemMeta netherstarMeta = netherstar.getItemMeta();
		
		//Close the Team Selector!
		ItemStack endereye = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta endereyeMeta = endereye.getItemMeta();
		
		endereyeMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"Close");
		endereye.setItemMeta(endereyeMeta);
		
		netherstarMeta.setDisplayName(String.format(ChatColor.GREEN+"%sAuto Join",ChatColor.BOLD));
		netherstar.setItemMeta(netherstarMeta);
		
		redteamMeta.setDisplayName(ChatColor.RED+"Red Team");
		redstone.setItemMeta(redteamMeta);
		
		blueteamMeta.setDisplayName(ChatColor.BLUE+"Blue Team");
		lapis.setItemMeta(blueteamMeta);
		
		inv.setItem(0, netherstar);
		inv.setItem(2, lapis);
		inv.setItem(4, redstone);
		inv.setItem(8, endereye);
		
		player.openInventory(inv);
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Team Selector"))
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		if(event.getCurrentItem()==null || event.getCurrentItem().getType() == Material.AIR ||!event.getCurrentItem().hasItemMeta()){
		player.closeInventory();
		return;
		}
		switch(event.getCurrentItem().getType()){
		case LAPIS_BLOCK:
          //Teleports you to the certain Cordinate |
			teleportInworld(player, 2, 65, -82);
			Team.blueteam.remove(player.getName());
			Team.blueteam.add(player.getName());
			player.sendMessage(String.format("%sYou Joined the %sBlue Team",ChatColor.GRAY,ChatColor.BLUE));
			player.closeInventory();
			break;
		case REDSTONE_BLOCK:
 		 //Teleports you to the certain Cordinate |
			teleportInworld(player, 9, 68, -8);
			player.sendMessage(String.format("%sYou Joined the %sRed Team",ChatColor.GRAY,ChatColor.RED));
			player.closeInventory();
			break;
		case NETHER_STAR:
			int i = 0;
	  		if(i < Bukkit.getOnlinePlayers().length/2){  
	  			Team.AddToTeam(TeamType.Blue, player);
	  		 //Teleports you to the certain Cordinate |
	  			teleportInworld(player, 2, 65, -82);
	  			Team.blueteam.remove(player.getName());
				Team.blueteam.add(player.getName());
				player.sendMessage(String.format("%sYou Joined the %sBlue Team",ChatColor.GRAY,ChatColor.BLUE));
	  			player.closeInventory();
			}else{
             //Teleports you to the certain Cordinate |
				Team.AddToTeam(TeamType.Red, player);
				Team.redteam.remove(player.getName());
				Team.redteam.add(player.getName());
				teleportInworld(player, 9, 68, -8);
				player.sendMessage(String.format("%sYou Joined the %sRed Team",ChatColor.GRAY,ChatColor.RED));
				player.closeInventory();
			}
	  		break;
		case EYE_OF_ENDER:
			player.closeInventory();
			break;
		default:
			player.closeInventory();
			break;
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
	 event.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Action a = event.getAction();
		ItemStack is = event.getItem();
	 if(a == Action.PHYSICAL || is == null || is.getType() == Material.AIR)
		return;
	 if( is.getType() ==Material.COMPASS)
		 openGUI(event.getPlayer());
	}
}
