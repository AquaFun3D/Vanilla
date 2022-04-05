package de.aquafun3d.vanilla.listeners

import de.aquafun3d.vanilla.utils.Utils
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent


class JoinQuitListener: Listener {

	@EventHandler
	fun onJoin(e: PlayerJoinEvent){
		val player: Player = e.player
		e.joinMessage(Component.text(Utils.PREFIX + ChatColor.AQUA.toString() + player.name + ChatColor.LIGHT_PURPLE.toString() + " has joined"))
	}

	@EventHandler
	fun onLeave(e: PlayerQuitEvent) {
		val player = e.player
		e.quitMessage(Component.text(Utils.PREFIX + ChatColor.AQUA.toString() + player.name + ChatColor.LIGHT_PURPLE.toString() + " has left"))
	}
}