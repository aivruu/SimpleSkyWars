package net.simpleskywars.plugin.managers;

import com.grinderwolf.swm.api.SlimePlugin;
import com.grinderwolf.swm.api.exceptions.CorruptedWorldException;
import com.grinderwolf.swm.api.exceptions.InvalidWorldException;
import com.grinderwolf.swm.api.exceptions.NewerFormatException;
import com.grinderwolf.swm.api.exceptions.UnknownWorldException;
import com.grinderwolf.swm.api.exceptions.WorldAlreadyExistsException;
import com.grinderwolf.swm.api.exceptions.WorldInUseException;
import com.grinderwolf.swm.api.exceptions.WorldLoadedException;
import com.grinderwolf.swm.api.exceptions.WorldTooBigException;
import com.grinderwolf.swm.api.loaders.SlimeLoader;
import com.grinderwolf.swm.api.world.properties.SlimeProperties;
import com.grinderwolf.swm.api.world.properties.SlimePropertyMap;
import net.simpleskywars.api.game.GameArena;
import net.simpleskywars.api.game.Games;
import net.simpleskywars.api.managers.GameManager;
import net.simpleskywars.plugin.SimpleSkyWars;
import net.simpleskywars.plugin.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SimpleGameManager
implements GameManager {
	private final SlimePlugin plugin;
	private final SlimeLoader loader;
	private final SlimePropertyMap properties;
	
	public SimpleGameManager(SlimePlugin plugin) {
		this.plugin = Objects.requireNonNull(plugin, "The SlimePlugin instance is null.");
		
		loader = plugin.getLoader("filesystem");
		properties = new SlimePropertyMap();
	}
	
	@Override
	public GameArena getGame(String gameName) {
		return Games.to(gameName);
	}
	
	@Override
	public void createGame(String gameName, int gameCapacity) {
		Games.addGame(gameName, new GameArena(gameName, gameCapacity));
	}
	
	@Override
	public void loadArena(String worldName, int x, int y, int z, String worldType) {
		properties.setInt(SlimeProperties.SPAWN_X, x);
		properties.setInt(SlimeProperties.SPAWN_Y, y);
		properties.setInt(SlimeProperties.SPAWN_Z, z);
		properties.setString(SlimeProperties.WORLD_TYPE, worldType);
		
		try { plugin.generateWorld(plugin.loadWorld(loader, worldName, true, properties)); }
		catch (UnknownWorldException | IOException | CorruptedWorldException | NewerFormatException | WorldInUseException exception) {
			LogUtils.error("Cannot load the world '" + worldName + "'.");
			if (LogUtils.isDebugEnabled()) exception.printStackTrace();
		}
	}
	
	@Override
	public void importArena(String worldName) {
		try {
			plugin.importWorld(
				 new File(SimpleSkyWars.getPlugin().getDataFolder() + File.separator + "arenas" + File.separator + worldName),
				 worldName,
				 loader
			);
		} catch (WorldAlreadyExistsException | IOException | WorldLoadedException | WorldTooBigException | InvalidWorldException exception) {
			LogUtils.error("Cannot import the world '" + worldName + "'.");
			if (LogUtils.isDebugEnabled()) exception.printStackTrace();
		}
	}
	
	@Override
	public void unloadGame(String gameName) {
	
	}
	
	@Override
	public void removeGame(String gameName) {
	
	}
}
