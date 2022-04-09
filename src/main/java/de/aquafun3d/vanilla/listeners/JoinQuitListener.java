package de.aquafun3d.vanilla.listeners;

import de.aquafun3d.vanilla.utils.Utils;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		e.joinMessage(Component.text(Utils.PREFIX + ChatColor.AQUA + player.getName() + ChatColor.LIGHT_PURPLE + " has joined"));
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player player = e.getPlayer();
		e.quitMessage(Component.text(Utils.PREFIX + ChatColor.AQUA + player.getName() + ChatColor.LIGHT_PURPLE + " has left"));

	}
}
