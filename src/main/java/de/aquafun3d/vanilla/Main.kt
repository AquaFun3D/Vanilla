package de.aquafun3d.vanilla

import de.aquafun3d.vanilla.commands.BackpackCommand
import de.aquafun3d.vanilla.commands.DeathpointCommand
import de.aquafun3d.vanilla.commands.GamemodeCommand
import de.aquafun3d.vanilla.commands.WaypointCommand
import de.aquafun3d.vanilla.listeners.*
import de.aquafun3d.vanilla.utils.VanillaConfig
import org.bukkit.Bukkit
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
	override fun onEnable() {
		Bukkit.getLogger().fine("Plugin activated")

		vanillaConfig = VanillaConfig()

		commandRegistration()
		listenerRegistration()
	}

	override fun onDisable() {
		Bukkit.getLogger().fine("Plugin deactivated")
	}

	private fun commandRegistration() {
		getCommand("gm")!!.setExecutor(GamemodeCommand())
		getCommand("waypoint")!!.setExecutor(WaypointCommand())
		getCommand("deathpoint")!!.setExecutor(DeathpointCommand())
		getCommand("backpack")!!.setExecutor(BackpackCommand())
	}

	private fun listenerRegistration() {
		pluginManager.registerEvents(JoinQuitListener(),this)
		pluginManager.registerEvents(DeathListener(),this)
		pluginManager.registerEvents(RespawnListener(),this)
		pluginManager.registerEvents(BackpackListener(),this)
	}

	companion object {
		val pluginManager: PluginManager = Bukkit.getPluginManager()
		var vanillaConfig: VanillaConfig? = null
	}
}