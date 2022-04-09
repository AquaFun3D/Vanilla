package de.aquafun3d.vanilla.commands;

import de.aquafun3d.vanilla.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(player.isOp()){
				if(args.length == 0){
					Utils.send(player, ChatColor.RED + "/gm <number>");
				}else if(args.length == 2){
					Player target = Bukkit.getPlayer(args[1]);
					GameMode gm = target.getGameMode();
					switch(Integer.parseInt(args[0])){
						case 0 -> {
							if(gm == GameMode.SURVIVAL){
								Utils.send(player, ChatColor.RED + "Player is already in survival mode");
							}else {
								target.setGameMode(GameMode.SURVIVAL);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.getName() + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "survival");
							}
						}
						case 1 -> {
							if(gm == GameMode.CREATIVE){
								Utils.send(player, ChatColor.RED + "Player is already in creative mode");
							}else {
								target.setGameMode(GameMode.CREATIVE);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.getName() + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "creative");
							}
						}
						case 2 -> {
							if(gm == GameMode.ADVENTURE){
								Utils.send(player, ChatColor.RED + "Player is already in adventure mode");
							}else {
								target.setGameMode(GameMode.ADVENTURE);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.getName() + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "adventure");
							}
						}
						case 3 -> {
							if(gm == GameMode.SPECTATOR){
								Utils.send(player, ChatColor.RED + "Player is already in spectator mode");
							}else {
								target.setGameMode(GameMode.SPECTATOR);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " sets " + ChatColor.AQUA + target.getName() + "s" + ChatColor.GOLD + " gamemode to " + ChatColor.BLUE + "spectator");
							}
						}
					}
				}else {
					switch(Integer.parseInt(args[0])){
						case 0 -> {
							if(player.getGameMode() == GameMode.SURVIVAL){
								Utils.send(player, ChatColor.RED + "You are already in survival mode");
							}else {
								player.setGameMode(GameMode.SURVIVAL);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "survival");
							}
						}
						case 1 -> {
							if(player.getGameMode() == GameMode.CREATIVE){
								Utils.send(player, ChatColor.RED + "You are already in creative mode");
							}else {
								player.setGameMode(GameMode.CREATIVE);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "creative");
							}
						}
						case 2 -> {
							if(player.getGameMode() == GameMode.ADVENTURE){
								Utils.send(player, ChatColor.RED + "You are already in adventure mode");
							}else {
								player.setGameMode(GameMode.ADVENTURE);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "adventure");
							}
						}
						case 3 -> {
							if(player.getGameMode() == GameMode.SPECTATOR){
								Utils.send(player, ChatColor.RED + "You are already in spectator mode");
							}else {
								player.setGameMode(GameMode.SPECTATOR);
								Utils.atAll(ChatColor.AQUA + player.getName() + ChatColor.GOLD + " set gamemode to " + ChatColor.BLUE + "spectator");
							}
						}
					}
				}
			}else{
				Utils.send(player,ChatColor.RED + "You don't have permissions to use that command");
			}
		}
		return false;
	}
}
