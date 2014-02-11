package me.skylertyler1337.teamplugin;

import me.skylertyler1337.teamplugin.Commands.*;

import org.bukkit.plugin.java.JavaPlugin;

   public class TeamPlugin extends JavaPlugin{



	@Override
	public void onEnable() {
	  System.out.println("[TeamPlugin] is Enabled!");
          getCommand("join").setExecutor(new JoinCommand(this));
	}
       
        @Override
         public void onDisable () {
          System.out.println("[TeamPlugin] is Disabled!"); 
      }
      // will work on later!
}

       
     
