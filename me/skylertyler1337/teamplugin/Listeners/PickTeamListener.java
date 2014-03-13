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
                        Team.AddToTeam(TeamType.Blue, player);
			teleportInworld(player, 2, 65, -82);
			Team.blueteam.remove(player.getName());
			Team.blueteam.add(player.getName());
	  // === armor ===			
            ItemStack leatherhelmet1 = new ItemStack(Material.LEATHER_HELMET);
            LeatherArmorMeta leatherhelmetmeta1 = (LeatherArmorMeta) leatherhelmet1.getItemMeta();
            leatherhelmetmeta1.setColor(Color.BLUE);
            leatherhelmet1.setItemMeta(leatherhelmetmeta1);
            //chesplate
            ItemStack leatherchestplate1 = new ItemStack(Material.LEATHER_CHESTPLATE);
            LeatherArmorMeta leatherchestplatemeta1 = (LeatherArmorMeta) leatherchestplate1.getItemMeta();
            leatherchestplatemeta1.setColor(Color.BLUE);
            leatherchestplate1.setItemMeta(leatherchestplatemeta1);
            //leggings
            ItemStack leatherlegging1 = new ItemStack(Material.LEATHER_LEGGINGS);
            LeatherArmorMeta leatherleggingmeta1 = (LeatherArmorMeta) leatherlegging1.getItemMeta();
            leatherleggingmeta1.setColor(Color.BLUE);
            leatherlegging1.setItemMeta(leatherleggingmeta1);
            //boots
            ItemStack leatherboot1 = new ItemStack(Material.LEATHER_BOOTS);
            LeatherArmorMeta leatherbootmeta1 = (LeatherArmorMeta) leatherboot1.getItemMeta();
            leatherbootmeta1.setColor(Color.BLUE);
            leatherboot1.setItemMeta(leatherbootmeta1);
            //adding to inventory
            PlayerInventory pi = player.getInventory();
            pi.setHelmet(leatherhelmet1);
            pi.setChestplate(leatherchestplate1);
            pi.setLeggings(leatherlegging1);
            pi.setBoots(leatherboot1);
			player.sendMessage(String.format("%sYou Joined the %sBlue Team",ChatColor.GRAY,ChatColor.BLUE));
			player.closeInventory();
			break;
		case REDSTONE_BLOCK:
 		 //Teleports you to the certain Cordinate |
 		        Team.AddToTeam(TeamType.Red, player);
			teleportInworld(player, 9, 68, -8);
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
            PlayerInventory pi1 = player.getInventory();
            pi1.setHelmet(leatherhelmet);
            pi1.setChestplate(leatherchestplate);
            pi1.setLeggings(leatherlegging);
            pi1.setBoots(leatherboot);
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
		   //Armor 
	              ItemStack leatherhelmet2 = new ItemStack(Material.LEATHER_HELMET);
	              LeatherArmorMeta leatherhelmetmeta2 = (LeatherArmorMeta) leatherhelmet2.getItemMeta();
	              leatherhelmetmeta2.setColor(Color.BLUE);
	              leatherhelmet2.setItemMeta(leatherhelmetmeta2);
	              
	              ItemStack leatherchestplate2 = new ItemStack(Material.LEATHER_CHESTPLATE);
	              LeatherArmorMeta leatherchestplatemeta2 = (LeatherArmorMeta) leatherchestplate2.getItemMeta();
	              leatherchestplatemeta2.setColor(Color.BLUE);
	              leatherchestplate2.setItemMeta(leatherhelmetmeta2);
	              
	              ItemStack leatherlegging2 = new ItemStack(Material.LEATHER_LEGGINGS);
	              LeatherArmorMeta leatherleggingmeta2 = (LeatherArmorMeta) leatherlegging2.getItemMeta();
	              leatherleggingmeta2.setColor(Color.BLUE);
	              leatherlegging2.setItemMeta(leatherleggingmeta2);
	              
	              ItemStack leatherboot2 = new ItemStack(Material.LEATHER_BOOTS);
	              LeatherArmorMeta leatherbootmeta2 = (LeatherArmorMeta) leatherboot2.getItemMeta();
	              leatherbootmeta2.setColor(Color.BLUE);
	              leatherboot2.setItemMeta(leatherbootmeta2);
	              //adding to inventory
	              PlayerInventory pi2 = player.getInventory();
	              pi2.setHelmet(leatherhelmet2);
	              pi2.setChestplate(leatherchestplate2);
	              pi2.setLeggings(leatherlegging2);
	              pi2.setBoots(leatherboot2);
				player.sendMessage(String.format("%sYou Joined the %sBlue Team",ChatColor.GRAY,ChatColor.BLUE));
	  			player.closeInventory();
			}else{
             //Teleports you to the certain Cordinate |
				Team.AddToTeam(TeamType.Red, player);
				Team.redteam.remove(player.getName());
				Team.redteam.add(player.getName());
				teleportInworld(player, 9, 68, -8);
               	    //Armor
                      ItemStack leatherhelmet3 = new ItemStack(Material.LEATHER_HELMET);
	              LeatherArmorMeta leatherhelmetmeta3 = (LeatherArmorMeta) leatherhelmet3.getItemMeta();
	              leatherhelmetmeta3.setColor(Color.RED);
	              leatherhelmet3.setItemMeta(leatherhelmetmeta3);
	              
	              ItemStack leatherchestplate3 = new ItemStack(Material.LEATHER_CHESTPLATE);
	              LeatherArmorMeta leatherchestplatemeta3 = (LeatherArmorMeta) leatherchestplate3.getItemMeta();
	              leatherchestplatemeta3.setColor(Color.RED);
	              leatherchestplate3.setItemMeta(leatherhelmetmeta3);
	              
	              ItemStack leatherlegging3 = new ItemStack(Material.LEATHER_LEGGINGS);
	              LeatherArmorMeta leatherleggingmeta3 = (LeatherArmorMeta) leatherlegging3.getItemMeta();
	              leatherleggingmeta3.setColor(Color.RED);
	              leatherlegging3.setItemMeta(leatherleggingmeta3);
	              
	              ItemStack leatherboot3 = new ItemStack(Material.LEATHER_BOOTS);
	              LeatherArmorMeta leatherbootmeta3 = (LeatherArmorMeta) leatherboot3.getItemMeta();
	              leatherbootmeta3.setColor(Color.RED);
	              leatherboot3.setItemMeta(leatherbootmeta3);
	              //adding to inventory
	              PlayerInventory pi3 = player.getInventory();
	              pi3.setHelmet(leatherhelmet3);
	              pi3.setChestplate(leatherchestplate3);
	              pi3.setLeggings(leatherlegging3);
	              pi3.setBoots(leatherboot3);
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
