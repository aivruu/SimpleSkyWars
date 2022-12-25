package net.simpleskywars.api.game;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.UUID;

public class GamePlayer {
	private final Player player;
	private final UUID uuid;
	private int level;
	private int wins;
	private int kills;
	private float experience;
	private ItemStack[] lobbyContents;
	private ItemStack[] gameContents;
	
	public GamePlayer(Player player, int level, int wins, int kills, float experience, ItemStack[] lobbyContents, ItemStack[] gameContents) {
		this.player = Objects.requireNonNull(player, "The Player object is null.");
		this.uuid = player.getUniqueId();
		this.level = level;
		this.wins = wins;
		this.kills = kills;
		this.experience = experience;
		this.lobbyContents = lobbyContents;
		this.gameContents = gameContents;
	}
	
	public void setLevel(int newLevel) {
		level = newLevel;
	}
	
	public void increaseLevel(int amount) {
		level += amount;
	}
	
	public void decreaseLevel(int amount) {
		level -= amount;
	}
	
	public void increaseWins(int amount) {
		wins += amount;
	}
	
	public void increaseKills(int amount) {
		kills += amount;
	}
	
	public void decreaseWins(int amount) {
		wins -= amount;
	}
	
	public void decreaseKills(int amount) {
		kills -= amount;
	}
	
	public void setExperience(float newExperience) {
		experience = newExperience;
	}
	
	public void increaseExperience(float amount) {
		experience += amount;
	}
	
	public void decreaseExperience(float amount) {
		experience -= amount;
	}
	
	public void setLobbyContents(ItemStack[] lobbyContents) {
		this.lobbyContents = lobbyContents;
	}
	
	public void setGameContents(ItemStack[] gameContents) {
		this.gameContents = gameContents;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public UUID getPlayerId() {
		return uuid;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getKills() {
		return kills;
	}
	
	public float getExperience() {
		return experience;
	}
	
	public ItemStack[] getLobbyContents() {
		return lobbyContents;
	}

	public ItemStack[] getGameContents() {
		return gameContents;
	}
}
