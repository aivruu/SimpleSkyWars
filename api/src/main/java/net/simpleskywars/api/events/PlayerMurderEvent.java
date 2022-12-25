package net.simpleskywars.api.events;

import net.simpleskywars.api.game.GamePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Objects;

public class PlayerMurderEvent
extends Event {
	private static final HandlerList HANDLER_LIST = new HandlerList();
	
	private final GamePlayer killer;
	private final GamePlayer victim;
	
	public PlayerMurderEvent(GamePlayer killer, GamePlayer victim) {
		this.killer = Objects.requireNonNull(killer, "The killer is null.");
		this.victim = Objects.requireNonNull(victim, "The victim is null.");
	}
	
	public GamePlayer getKiller() {
		return killer;
	}
	
	public GamePlayer getVictim() {
		return victim;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLER_LIST;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLER_LIST;
	}
}
