package net.simpleskywars.api.events;

import net.simpleskywars.api.game.GameArena;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Objects;

public class GameJoinEvent
extends Event {
	private static final HandlerList HANDLER_LIST = new HandlerList();
	
	private final Player player;
	private final GameArena game;
	
	public GameJoinEvent(Player player, GameArena game) {
		this.player = Objects.requireNonNull(player, "The player is null.");
		this.game = Objects.requireNonNull(game, "The GameArena object for this game is null.");
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public GameArena getGame() {
		return game;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLER_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLER_LIST;
	}
}
