package de.aquafun3d.vanilla.commands;

import de.aquafun3d.vanilla.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BackpackCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command,  String label, String[] args){
		if(sender instanceof Player){
			Player player = (Player) sender;
			Inventory inv = Bukkit.createInventory(null,27, Component.text(ChatColor.DARK_PURPLE + "Backpack"));
			if(Main.vanillaConfig.contains("backpack." + player.getUniqueId())){
				for(int i = 0; i < 26;i++){
					ItemStack item;
					if(Main.vanillaConfig.get("backpack." + player.getUniqueId() + "." + i) == null){
						item = new ItemStack(Material.AIR);
						inv.setItem(i, item);
					}else{
						item = (ItemStack) Main.vanillaConfig.get("backpack." + player.getUniqueId() + "." + i);
						inv.setItem(i, item);
					}
				}
			}
			player.openInventory(inv);
		}
		return false;
	}
}
