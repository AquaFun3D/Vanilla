package de.aquafun3d.vanilla.commands

import de.aquafun3d.vanilla.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class GamemodeCommand: CommandExecutor {

	override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
		if(sender is Player) {
			val player: Player = sender
			if(player.isOp){
				 if(args.isEmpty()){
					 player.sendMessage(Utils.PREFIX + ChatColor.RED + "/gm <number>")
				 }else if(args.size == 2){ // assining gamemode to another
					 val target: Player = Bukkit.getPlayer(args[1])!!
					 val gm: GameMode = target.gameMode
					 when(args[0].toInt()){
						 0 -> 	if (gm == GameMode.SURVIVAL) {
							 		Utils.send(player,ChatColor.RED.toString() + "Player is already in survival mode")
							 	}else{
							 		target.gameMode = GameMode.SURVIVAL
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.name + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "survival")
						 		}
						 1 ->	if (gm == GameMode.CREATIVE) {
							 		Utils.send(player,ChatColor.RED.toString() + "Player is already in creative mode")
						 		}else{
						 			target.gameMode = GameMode.CREATIVE
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.name + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "creative")
						 		}
						 2 ->	if (gm == GameMode.ADVENTURE) {
							 		Utils.send(player,ChatColor.RED.toString() + "Player is already in adventure mode")
						 		}else{
							 		target.gameMode = GameMode.ADVENTURE
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.name + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "adventure")
						 		}
						 3 ->	if (gm == GameMode.SPECTATOR) {
							 		Utils.send(player,ChatColor.RED.toString() + "Player is already in spectator mode")
						 		}else{
							 		target.gameMode = GameMode.SPECTATOR
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.name + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "spectator")
						 		}
					 }
				 }else{ //assigning gamemode to self
					 when(args[0].toInt()){
						 0 -> 	if(player.gameMode == GameMode.SURVIVAL){
							 		Utils.send(player,ChatColor.RED.toString() + "You are already in survival mode")
						 		}else{
									player.gameMode = GameMode.SURVIVAL
									Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "survival")
						 		}
						 1 -> 	if(player.gameMode == GameMode.CREATIVE){
							 		Utils.send(player,ChatColor.RED.toString() + "You are already in creative mode")
						 		}else{
							 		player.gameMode = GameMode.CREATIVE
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "creative")
						 		}
						 2 -> 	if(player.gameMode == GameMode.ADVENTURE){
							 		Utils.send(player,ChatColor.RED.toString() + "You are already in adventure mode")
						 		}else{
							 		player.gameMode = GameMode.ADVENTURE
							 		Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "adventure")
						 		}
						 3 -> 	if(player.gameMode == GameMode.SPECTATOR){
							 		Utils.send(player,ChatColor.RED.toString() + "You are already in spectator mode")
						 		}else{
									player.gameMode = GameMode.SPECTATOR
									Utils.atAll(Utils.PREFIX + ChatColor.AQUA + player.name + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "spectator")
						 		}
					 }
				 }
			}else{
				Utils.send(player,ChatColor.RED.toString() + "You don't have permissions to use that command")
			}
		}
		return false
	}
}