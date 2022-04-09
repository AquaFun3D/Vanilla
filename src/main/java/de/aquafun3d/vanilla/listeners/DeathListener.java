package de.aquafun3d.vanilla.listeners;

import de.aquafun3d.vanilla.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.io.IOException;

public class DeathListener implements Listener {
	@EventHandler
	public void onDeath(PlayerDeathEvent e) throws IOException {
		Player player = e.getPlayer();
		Main.vanillaConfig.set("deathpoint." + player.getUniqueId() + ".world", player.getWorld().getName());
	}

}
