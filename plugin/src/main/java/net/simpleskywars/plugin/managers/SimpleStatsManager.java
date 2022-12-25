package net.simpleskywars.plugin.managers;

import net.simpleskywars.api.game.GamePlayer;
import net.simpleskywars.api.game.Games;
import net.simpleskywars.api.managers.StatsManager;
import org.bukkit.entity.Player;

public class SimpleStatsManager
implements StatsManager {
	public SimpleStatsManager() {}
	
	@Override
	public String[] getPlayerStats(Player player) {
		GamePlayer gamePlayer = Games.getPlayer(player);
		
		return new String[] {
			 "level:" + gamePlayer.getLevel(),
			 "kills:" + gamePlayer.getKills(),
			 "wins:" + gamePlayer.getWins(),
			 "experience:" + gamePlayer.getExperience()
		};
	}
	
	@Override
	public void increaseLevel(Player player, int amount) {
		Games.getPlayer(player).increaseLevel(amount);
	}
	
	@Override
	public void increaseExperience(Player player, float amount) {
		Games.getPlayer(player).increaseExperience(amount);
	}
	
	@Override
	public void decreaseLevel(Player player, int amount) {
		Games.getPlayer(player).decreaseLevel(amount);
	}
	
	@Override
	public void decreaseExperience(Player player, float amount) {
		Games.getPlayer(player).decreaseExperience(amount);
	}
	
	@Override
	public void increaseWins(Player player, int amount) {
		Games.getPlayer(player).increaseWins(amount);
	}
	
	@Override
	public void decreaseWins(Player player, int amount) {
		Games.getPlayer(player).decreaseWins(amount);
	}
	
	@Override
	public void increaseKills(Player player, int amount) {
		Games.getPlayer(player).increaseKills(amount);
	}
	
	@Override
	public void decreaseKills(Player player, int amount) {
		Games.getPlayer(player).decreaseKills(amount);
	}
}
