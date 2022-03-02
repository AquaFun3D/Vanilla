package de.aquafun3d.vanilla.utils

import org.bukkit.Bukkit
import org.bukkit.ChatColor

object Utils {
	val PREFIX: String = "" + ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Server" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_PURPLE

	//Sends message to all players with Challenge prefix
	fun atAll(message: String){
		for(p in Bukkit.getOnlinePlayers()){
			p.sendMessage("$PREFIX$message")
		}
	}
}