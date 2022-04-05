package de.aquafun3d.vanilla.commands

import de.aquafun3d.vanilla.Main
import de.aquafun3d.vanilla.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class DeathpointCommand: CommandExecutor {
	override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
		if(sender is Player){
			val player: Player = sender
			Utils.sendDeathpoint(player)
		}
		return false
	}
}