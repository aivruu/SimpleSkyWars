package net.simpleskywars.api.actions;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public interface SimpleAction {
	ActionContext getContext();
	
	void execute(JavaPlugin plugin, Player player, String container);
}
