package de.aquafun3d.vanilla.listeners

import de.aquafun3d.vanilla.Main
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import java.awt.TextComponent
import java.io.IOException

class BackpackListener: Listener {

	@EventHandler
	@Throws(IOException::class)
	fun onInvClose(e: InventoryCloseEvent) {
		val title = e.view.title()
		val inv = e.inventory
		val player = e.player as Player
		if (title == Component.text(ChatColor.DARK_PURPLE.toString() + "Backpack")) {
			Main.vanillaConfig?.set("backpack." + player.uniqueId.toString(), null)
			for (i in 0..26) {
				val item = inv.getItem(i) ?: continue
				if (item.type == Material.AIR) continue
				Main.vanillaConfig?.set("backpack." + player.uniqueId.toString() + "." + i, item)
			}
		}
	}
}