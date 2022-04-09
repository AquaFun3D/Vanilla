package de.aquafun3d.vanilla.utils;

import de.aquafun3d.vanilla.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

	public static String PREFIX = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Server" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_PURPLE;

	public static void send(Player player, String message){
		player.sendMessage(PREFIX + message);
	}

	public static void atAll(String message){
		Bukkit.broadcast(Component.text(PREFIX + message));
	}

	public static void sendDeathpoint(Player player){
		if (Main.vanillaConfig.contains("deathpoint." + player.getUniqueId())) {
			String w = Main.vanillaConfig.getString("deathpoint." + player.getUniqueId() + ".world");
			int x = Main.vanillaConfig.getInt("deathpoint." + player.getUniqueId() + ".x");
			int y = Main.vanillaConfig.getInt("deathpoint." + player.getUniqueId() + ".y");
			int z = Main.vanillaConfig.getInt("deathpoint." + player.getUniqueId() + ".z");
			switch (w) {
				case "world" -> send(player, ChatColor.GOLD + "Deathpoint" + ChatColor.GREEN + " " + x + ", " + y + ", " + z + ChatColor.GOLD + " in overworld");
				case "world_nether" -> send(player, ChatColor.GOLD + "Deathpoint" + ChatColor.GREEN + " " + x + ", " + y + ", " + z + ChatColor.GOLD + " in nether");
				case "world_the_end" -> send(player, ChatColor.GOLD + "Deathpoint" + ChatColor.GREEN + " " + x + ", " + y + ", " + z + ChatColor.GOLD + " in end");
			}
		}else{
			send(player,ChatColor.RED + "You got no deathpoint");
		}

	}
}
