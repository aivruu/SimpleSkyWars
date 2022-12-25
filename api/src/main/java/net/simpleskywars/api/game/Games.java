package net.simpleskywars.api.game;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Games {
	private static final Map<String, GameArena> games = new HashMap<>();
	private static final Map<Player, GamePlayer> players = new HashMap<>();
	
	public Games() {}
	
	public static void addGame(String gameName, GameArena game) {
		games.put(gameName, game);
	}
	
	public static void removeGame(String gameName) {
		games.remove(gameName);
	}
	
	public static void addNewPlayer(Player player) {
		players.put(player, new GamePlayer(
			 player,
			 player.getLevel(),
			 0,
			 0,
			 player.getExp(),
			 player.getInventory().getContents(),
			 null
		));
	}
	
	public static void removePlayer(Player player) {
		players.remove(player);
	}
	
	public static GamePlayer getPlayer(Player player) {
		return players.get(player);
	}
	
	public static String of(GameArena gameArena) {
		return "{" + gameArena.getName() + ";" + gameArena.getCapacity() + "}";
	}
	
	public static GameArena to(String gameName) {
		return games.get(gameName);
	}
}
