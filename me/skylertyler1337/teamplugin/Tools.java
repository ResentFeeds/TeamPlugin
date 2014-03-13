package me.skylertyler1337.teamplugin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Tools {
	
	//Hide a player and change his gamemode to creative
		 public static void hidePlayer(Player p) {
			p.setGameMode(GameMode.CREATIVE);
			for (Player op : Bukkit.getOnlinePlayers()) {
				op.hidePlayer(p);
			}
		 }
		//Show a player and change his gamemode to survival
		public static void showPlayer(Player p) {
			p.setGameMode(GameMode.SURVIVAL);
			for (Player op : Bukkit.getOnlinePlayers()) {
				op.showPlayer(p);
			}
		}
}
