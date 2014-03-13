package me.skylertyler1337.teamplugin.Listeners;

import me.skylertyler1337.teamplugin.TeamPlugin;
import me.skylertyler1337.teamplugin.Teams.Team;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
	
	public TeamPlugin plugin;

	public EntityDamageListener(TeamPlugin teamPlugin) {
		this.plugin = teamPlugin;
	}

	@EventHandler
	public void onEntityInteract(EntityDamageEvent event){
		event.getEntity().getLocation().getWorld().playEffect(event.getEntity().getLocation().add(0,1,0), Effect.STEP_SOUND, 152);
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		Player attacker = null;
		Player damager = null;
	 if(event.getDamager() instanceof Player){
		 attacker = (Player)event.getDamager();
	 }
	 if (event.getEntity() instanceof Player) {
         damager = (Player)event.getEntity();
     }
	 if (damager == null)
         return;
     
     if (attacker == null)
         return;
     
     if (Team.obsteam.contains(damager)) {
         event.setCancelled(true);
     }
     if (Team.redteam.contains(damager) && Team.redteam.contains(attacker)) {
         event.setCancelled(true);
     }
     if (Team.blueteam.contains(damager) && Team.blueteam.contains(attacker)) {
         event.setCancelled(true);
     }
	}
}
