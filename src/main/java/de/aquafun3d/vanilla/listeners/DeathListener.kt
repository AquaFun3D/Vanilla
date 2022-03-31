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
		Main.vanillaConfig?.set("deathpoint." + player.uniqueId.toString() + ".world", player.world.name)
		Main.vanillaConfig?.set("deathpoint." + player.uniqueId.toString() + ".x", player.world.name)
		Main.vanillaConfig?.set("deathpoint." + player.uniqueId.toString() + ".y", player.world.name)
		Main.vanillaConfig?.set("deathpoint." + player.uniqueId.toString() + ".z", player.world.name)
		println("Deathpoint for player " + player.name + " set")
	}
}