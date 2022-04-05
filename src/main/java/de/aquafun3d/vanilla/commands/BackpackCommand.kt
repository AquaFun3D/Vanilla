package de.aquafun3d.vanilla.commands

import de.aquafun3d.vanilla.Main
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack


class BackpackCommand: CommandExecutor {
	override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
		if (sender is Player){
			val player: Player = sender
			val inv: Inventory = Bukkit.createInventory(null,27, Component.text(ChatColor.DARK_PURPLE.toString() + "Backpack"))
			if (Main.vanillaConfig?.contains("backpack." + player.uniqueId.toString()) == true) {
				for (i in 0..26) {
					var item: ItemStack
					if (Main.vanillaConfig?.get("backpack." + player.uniqueId.toString() + "." + i) == null) {
						item = ItemStack(Material.AIR)
						inv.setItem(i, item)
					} else {
						item = Main.vanillaConfig?.get("backpack." + player.uniqueId.toString() + "." + i) as ItemStack
						inv.setItem(i, item)
					}
				}
			}
			player.openInventory(inv)
		}
		return false
	}
}