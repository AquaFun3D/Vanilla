package de.aquafun3d.vanilla.listeners

import de.aquafun3d.vanilla.Main
import de.aquafun3d.vanilla.utils.Utils
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerRespawnEvent


class RespawnListener: Listener {

	@EventHandler
	fun onRespawn(e: PlayerRespawnEvent) {
		val player = e.player
		Utils.sendDeathpoint(player)
	}

}