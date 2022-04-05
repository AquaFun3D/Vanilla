package de.aquafun3d.vanilla.listeners

import de.aquafun3d.vanilla.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerBedEnterEvent


class SleepListener: Listener {

	@EventHandler
	fun onPlayerSleep(e: PlayerBedEnterEvent) {
		val player = e.player
		if (e.bedEnterResult == PlayerBedEnterEvent.BedEnterResult.OK) {
			Utils.atAll(ChatColor.AQUA.toString() + player.name + ChatColor.GOLD.toString() + " is now sleeping...")
		}
	}
}