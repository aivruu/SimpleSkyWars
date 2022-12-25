package net.simpleskywars.api.game;

import com.google.common.base.Preconditions;

import java.util.Objects;

public class GameArena {
	private final String name;
	private final int capacity;
	
	public GameArena(String name, int capacity) {
		this.name = Objects.requireNonNull(name, "The name of the game are null.");
		Preconditions.checkArgument(!name.isEmpty(), "The game name is empty.");
		
		this.capacity = capacity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}
}
