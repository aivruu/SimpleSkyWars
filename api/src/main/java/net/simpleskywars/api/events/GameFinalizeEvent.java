package net.simpleskywars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collection;
import java.util.Objects;

public class GameFinalizeEvent
extends Event {
	private static final HandlerList HANDLER_LIST = new HandlerList();
	
	private final Collection<Player> players;
	private final Player winner;
	
	public GameFinalizeEvent(Collection<Player> players, Player winner) {
		this.players = Objects.requireNonNull(players, "The collection of the players are null.");
		this.winner = Objects.requireNonNull(winner, "The winner of game is null.");
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	public Player getWinner() {
		return winner;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLER_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLER_LIST;
	}
}
