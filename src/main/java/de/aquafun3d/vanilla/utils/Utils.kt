package de.aquafun3d.vanilla.utils

import de.aquafun3d.vanilla.Main
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player

object Utils {
	val PREFIX: String = "${ChatColor.DARK_GRAY}[${ChatColor.DARK_AQUA}Server${ChatColor.DARK_GRAY}] ${ChatColor.DARK_PURPLE}"

	//Sends message to player with Challenge prefix
	fun send(player: Player,message: String){
		player.sendMessage("$PREFIX$message")
	}

	//Sends message to all players with Challenge prefix
	fun atAll(message: String){
		Bukkit.broadcast(Component.text("$PREFIX$message"))
	}

	fun sendDeathpoint(player: Player){
		if (Main.vanillaConfig!!.contains("deathpoint.${player.uniqueId}")) {
			val w: String = Main.vanillaConfig!!.getString("deathpoint.${player.uniqueId}.world")!!
			val x = Main.vanillaConfig!!.getInt("deathpoint.${player.uniqueId}.x")
			val y = Main.vanillaConfig!!.getInt("deathpoint.${player.uniqueId}.y")
			val z = Main.vanillaConfig!!.getInt("deathpoint.${player.uniqueId}.z")
			when (w) {
				"world" -> {
					send(player,"${ChatColor.GOLD}Deathpoint ${ChatColor.GREEN}$x,$y,$z ${ChatColor.GOLD}in overworld")
				}
				"world_nether" -> {
					send(player,"${ChatColor.GOLD}Deathpoint ${ChatColor.GREEN}$x,$y,$z ${ChatColor.GOLD}in in nether")
				}
				"world_the_end" -> {
					send(player,"${ChatColor.GOLD}Deathpoint ${ChatColor.GREEN}$x,$y,$z ${ChatColor.GOLD}in in end")
				}
			}
		}else{
			send(player,"${ChatColor.RED}You got no deathpoint")
		}
	}
}