package net.simpleskywars.api.managers;

import net.simpleskywars.api.actions.ActionContext;
import net.simpleskywars.api.actions.SimpleAction;
import org.bukkit.entity.Player;

import java.util.List;

public interface ActionManager {
	default void register(SimpleAction... actions) {
		for (SimpleAction action : actions) {
			register(action.getContext(), action);
		}
	}
	
	default void execute(Player player, List<String> containers) {
		for (String container : containers) {
			execute(player, container);
		}
	}
	
	void register(ActionContext context, SimpleAction action);
	
	void execute(Player player, String container);
	
	void unregister(ActionContext context);
	
	void unregisterAll();
}
