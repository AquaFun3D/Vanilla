package de.aquafun3d.vanilla

import de.aquafun3d.vanilla.commands.GamemodeCommand
import de.aquafun3d.vanilla.commands.WaypointCommand
import de.aquafun3d.vanilla.listeners.JoinQuitListener
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
	}

	private fun listenerRegistration() {
		pluginManager.registerEvents(JoinQuitListener(),this)
		pluginManager.registerEvents(SleepListener(),this)
	}

	companion object {
		val pluginManager: PluginManager = Bukkit.getPluginManager()
		var vanillaConfig: VanillaConfig? = null
	}
}