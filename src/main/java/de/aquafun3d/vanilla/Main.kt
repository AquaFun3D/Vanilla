package de.aquafun3d.vanilla

import de.aquafun3d.vanilla.commands.DeathpointCommand
import de.aquafun3d.vanilla.commands.GamemodeCommand
import de.aquafun3d.vanilla.commands.WaypointCommand
import de.aquafun3d.vanilla.listeners.DeathListener
import de.aquafun3d.vanilla.listeners.JoinQuitListener
import de.aquafun3d.vanilla.listeners.RespawnListener
import de.aquafun3d.vanilla.listeners.SleepListener
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
	}

	private fun listenerRegistration() {
		pluginManager.registerEvents(JoinQuitListener(),this)
		pluginManager.registerEvents(SleepListener(),this)
		pluginManager.registerEvents(DeathListener(),this)
		pluginManager.registerEvents(RespawnListener(),this)
	}

	companion object {
		val pluginManager: PluginManager = Bukkit.getPluginManager()
		var vanillaConfig: VanillaConfig? = null
	}
}