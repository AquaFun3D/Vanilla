package de.aquafun3d.vanilla.listeners;

import de.aquafun3d.vanilla.Main;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class BackpackListener implements Listener {
	@EventHandler
	public void onInvClose(InventoryCloseEvent e) throws IOException {
		Component title = e.getView().title();
		Inventory inv = e.getInventory();
		Player player = (Player) e.getPlayer();
		if(title.equals(Component.text(ChatColor.DARK_PURPLE + "Backpack"))) {
			Main.vanillaConfig.set("backpack." + player.getUniqueId(), null);
			for(int i = 0; i < 27;i++){
				ItemStack item = inv.getItem(i);
				if(item == null){
					continue;
				}
				if(item.getType() == Material.AIR){
					continue;
				}
				Main.vanillaConfig.set("backpack." + player.getUniqueId() + "." + i, item);
			}
		}
	}
}
