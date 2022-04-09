package de.aquafun3d.vanilla.commands;

import de.aquafun3d.vanilla.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DeathpointCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(sender instanceof Player){
			Player player = (Player) sender;
			Utils.sendDeathpoint(player);
		}
		return false;
	}
}
