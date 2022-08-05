package de.aquafun3d.vanilla.listeners

import de.aquafun3d.vanilla.Main
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import java.io.IOException

class DeathListener: Listener {

	@EventHandler
	@Throws(IOException::class)
	fun onPlayerDeath(e: PlayerDeathEvent) {
		val player = e.entity
		Main.vanillaConfig?.set("deathpoint.${player.uniqueId}.world", player.world.name)
		Main.vanillaConfig?.set("deathpoint.${player.uniqueId}.x", player.location.x)
		Main.vanillaConfig?.set("deathpoint.${player.uniqueId}.y", player.location.y)
		Main.vanillaConfig?.set("deathpoint.${player.uniqueId}.z", player.location.z)
	}
}