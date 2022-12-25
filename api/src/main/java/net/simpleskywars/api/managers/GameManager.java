package net.simpleskywars.api.managers;

import net.simpleskywars.api.game.GameArena;

public interface GameManager {
	GameArena getGame(String gameName);
	
	void createGame(String gameName, int gameCapacity);
	
	void loadArena(String worldName, int x, int y, int z, String worldType);
	
	void importArena(String worldName);
	
	void unloadGame(String gameName);
	
	void removeGame(String gameName);
}
