package net.simpleskywars.plugin;

import com.grinderwolf.swm.api.SlimePlugin;
import net.simpleskywars.api.managers.ActionManager;
import net.simpleskywars.api.managers.GameManager;
import net.simpleskywars.plugin.factories.ManagerFactory;
import net.simpleskywars.plugin.utils.LogUtils;
import net.xconfig.bukkit.XConfigBukkit;
import net.xconfig.bukkit.config.BukkitConfigurationHandler;
import net.xconfig.bukkit.config.BukkitConfigurationModel;
import net.xtitle.api.AdaptManager;
import net.xtitle.api.TitleManager;
import net.xtitle.lib.XTitle;

import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleSkyWars
extends JavaPlugin {
	private static SimpleSkyWars plugin;
	
	private BukkitConfigurationModel configurationManager;
	private BukkitConfigurationHandler configurationHandler;
	private AdaptManager adaptManager;
	private TitleManager titleManager;
	private SlimePlugin slimePlugin;
	private GameManager gameManager;
	private ActionManager actionManager;
	
	public static SimpleSkyWars getPlugin() {
		if (plugin == null) throw new IllegalStateException("Cannot get the SimpleSkyWars object instance because isn't initialized.");
		
		return plugin;
	}
	
	public TitleManager getTitleManager() {
		return titleManager;
	}
	
	@Override
	public void onLoad() {
		plugin = this;
		
		configurationManager = XConfigBukkit.manager(plugin);
		configurationHandler = XConfigBukkit.handler(configurationManager);
		adaptManager = XTitle.newAdaptManager();
		adaptManager.findAdapt();
		titleManager = XTitle.newTitleManager(adaptManager.getAdapt());
		slimePlugin = (SlimePlugin) getServer().getPluginManager().getPlugin("SlimeWorldManager");
		gameManager = ManagerFactory.newGameManager(slimePlugin);
		actionManager = ManagerFactory.newActionManager(this);
	
		LogUtils.setDebugEnabled(true);
	}
	
	@Override
	public void onEnable() {
		configurationManager.build("", "config.yml", "messages.yml");
	}
	
	@Override
	public void onDisable() {
		if (configurationManager != null) configurationManager = null;
		if (configurationHandler != null) configurationHandler = null;
		
		if (titleManager != null) titleManager = null;
		if (adaptManager != null) adaptManager = null;
		
		if (gameManager != null) gameManager = null;
		if (actionManager != null) {
			actionManager.unregisterAll();
			actionManager = null;
		}
		
		if (plugin != null) plugin = null;
		
		LogUtils.setDebugEnabled(false);
	}
}
