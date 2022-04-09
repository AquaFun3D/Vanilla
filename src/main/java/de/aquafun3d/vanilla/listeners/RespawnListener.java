package de.aquafun3d.vanilla.listeners;

import de.aquafun3d.vanilla.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e){
		Player player = e.getPlayer();
		Utils.sendDeathpoint(player);
	}
}
