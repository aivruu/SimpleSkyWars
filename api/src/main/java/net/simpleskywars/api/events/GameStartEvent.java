package net.simpleskywars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collection;
import java.util.Objects;

public class GameStartEvent
extends Event {
	private static final HandlerList HANDLER_LIST = new HandlerList();
	
	private final Collection<Player> players;
	
	public GameStartEvent(Collection<Player> players) {
		this.players = Objects.requireNonNull(players, "The collection of the players are null.");
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLER_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLER_LIST;
	}
}
