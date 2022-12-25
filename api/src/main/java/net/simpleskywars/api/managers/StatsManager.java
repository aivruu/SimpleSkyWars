package net.simpleskywars.api.managers;

import org.bukkit.entity.Player;

public interface StatsManager {
	String[] getPlayerStats(Player player);
	
	void increaseLevel(Player player, int amount);
	
	void increaseExperience(Player player, float amount);
	
	void decreaseLevel(Player player, int amount);
	
	void decreaseExperience(Player player, float amount);
	
	void increaseWins(Player player, int amount);
	
	void decreaseWins(Player player, int amount);
	
	void increaseKills(Player player, int amount);
	
	void decreaseKills(Player player, int amount);
	
	default void increaseOneLevel(Player player) {
		increaseLevel(player, 1);
	}
	
	default void increaseOneWin(Player player) {
		increaseWins(player, 1);
	}
	
	default void increaseOneKill(Player player) {
		increaseKills(player, 1);
	}
	
	default void decreaseOneLevel(Player player) {
		increaseLevel(player, 1);
	}
	
	default void decreaseOneWin(Player player) {
		decreaseWins(player, 1);
	}
	
	default void decreaseOneKill(Player player) {
		decreaseKills(player, 1);
	}
}
