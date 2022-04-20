package de.aquafun3d.vanilla;

import de.aquafun3d.vanilla.commands.BackpackCommand;
import de.aquafun3d.vanilla.commands.DeathpointCommand;
import de.aquafun3d.vanilla.commands.GamemodeCommand;
import de.aquafun3d.vanilla.commands.WaypointCommand;
import de.aquafun3d.vanilla.listeners.*;
import de.aquafun3d.vanilla.utils.VanillaConfig;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	public Main plugin;
	public static VanillaConfig vanillaConfig;

	@Override
	public void onEnable() {
		Bukkit.getLogger().fine("Plugin activated");
		plugin = this;

		listenerRegistration();
		commandRegistraion();

		vanillaConfig = new VanillaConfig();

	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().fine("Plugin deactivated");
	}

	private void commandRegistraion(){
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("waypoint").setExecutor(new WaypointCommand());
		getCommand("deathpoint").setExecutor(new DeathpointCommand());
		getCommand("backpack").setExecutor(new BackpackCommand());
	}

	private void listenerRegistration(){
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new JoinQuitListener(),this);
		pluginManager.registerEvents(new DeathListener(),this);
		pluginManager.registerEvents(new RespawnListener(),this);
		pluginManager.registerEvents(new BackpackListener(),this);
	}

}
