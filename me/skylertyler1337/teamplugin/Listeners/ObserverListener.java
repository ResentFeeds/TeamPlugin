package me.skylertyler1337.teamplugin.Listeners;
import me.skylertyler1337.teamplugin.TeamPlugin;
import org.bukkit.event.Listener;
   public class ObserverListener implements Listener{
 public TeamPlugin instance;

  public void ObserverListener(TeamPlugin instance){
    this.plugin = instance;
    }
    
    @EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		if(Team.obsteam.contains(event.getPlayer())){
		   event.setCancelled(true);
		if(!Team.obsteam.contains(event.getPlayer()))
				return;
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(Team.obsteam.contains(event.getPlayer())){
		  event.setCancelled(true);
		 if(!Team.obsteam.contains(event.getPlayer()))
			return;
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if(!Team.obsteam.contains(player.getName()))
			return;
		if(Team.obsteam.contains(player.getName())){
			event.setCancelled(true);
			}
		}
	
}
    
  }
