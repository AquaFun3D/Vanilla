package de.aquafun3d.vanilla.utils

import de.aquafun3d.vanilla.Main
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object Utils {
	val PREFIX: String = "" + ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Server" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_PURPLE

	//Sends message to all players with Challenge prefix
	fun atAll(message: String){
		for(p in Bukkit.getOnlinePlayers()){
			p.sendMessage("$PREFIX$message")
		}
	}

	fun sendDeathpoint(player: Player){
		if (Main.vanillaConfig!!.contains("deathpoint." + player.uniqueId.toString())) {
			val w: String = Main.vanillaConfig!!.getString("deathpoint." + player.uniqueId.toString() + ".world")!!
			val x = Main.vanillaConfig!!.getInt("deathpoint." + player.uniqueId.toString() + ".x")
			val y = Main.vanillaConfig!!.getInt("deathpoint." + player.uniqueId.toString() + ".y")
			val z = Main.vanillaConfig!!.getInt("deathpoint." + player.uniqueId.toString() + ".z")
			when (w) {
				"world" -> {
					player.sendMessage(PREFIX + ChatColor.GOLD.toString() + "Deathpoint" + ChatColor.GREEN.toString() + " " + x.toString() + ", " + y.toString() + ", " + z + ChatColor.GOLD.toString() + " in overworld")
				}
				"world_nether" -> {
					player.sendMessage(PREFIX + ChatColor.GOLD.toString() + "Deathpoint" + ChatColor.GREEN.toString() + " " + x.toString() + ", " + y.toString() + ", " + z + ChatColor.GOLD.toString() + " in nether")
				}
				"world_the_end" -> {
					player.sendMessage(PREFIX + ChatColor.GOLD.toString() + "Deathpoint" + ChatColor.GREEN.toString() + " " + x.toString() + ", " + y.toString() + ", " + z + ChatColor.GOLD.toString() + " in end")
				}
			}
		}else{
			player.sendMessage(PREFIX + ChatColor.RED + "You got no deathpoint")
		}
	}
}