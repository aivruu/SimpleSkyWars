package net.simpleskywars.plugin.factories;

import com.grinderwolf.swm.api.SlimePlugin;
import net.simpleskywars.plugin.SimpleSkyWars;
import net.simpleskywars.plugin.managers.SimpleActionManager;
import net.simpleskywars.plugin.managers.SimpleGameManager;

public interface ManagerFactory {
	static SimpleGameManager newGameManager(SlimePlugin plugin) {
		return new SimpleGameManager(plugin);
	}

	static SimpleActionManager newActionManager(SimpleSkyWars plugin) {
		return new SimpleActionManager(plugin);
	}
}
