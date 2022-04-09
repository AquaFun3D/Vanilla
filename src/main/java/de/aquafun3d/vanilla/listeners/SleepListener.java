package de.aquafun3d.vanilla.listeners;

import de.aquafun3d.vanilla.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class SleepListener implements Listener {
	@EventHandler
	public void onSleep(PlayerBedEnterEvent e){
		Player player = e.getPlayer();
		if (e.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK) {
			Utils.send(player, ChatColor.AQUA + player.getName() + ChatColor.GOLD + " is now sleeping...");
		}
	}
}
