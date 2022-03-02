package de.aquafun3d.vanilla

import org.bukkit.Bukkit
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
	override fun onEnable() {
		Bukkit.getLogger().fine("Plugin activated")

		commandRegistration()
		listenerRegistration()
	}

	override fun onDisable() {
		Bukkit.getLogger().fine("Plugin deactivated")
	}

	private fun commandRegistration() {

	}

	private fun listenerRegistration() {

	}

	companion object {
		val pluginManager: PluginManager = Bukkit.getPluginManager()
	}
}