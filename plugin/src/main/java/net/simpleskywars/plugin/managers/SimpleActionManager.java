package net.simpleskywars.plugin.managers;

import net.simpleskywars.api.actions.ActionContext;
import net.simpleskywars.api.actions.SimpleAction;
import net.simpleskywars.api.managers.ActionManager;
import net.simpleskywars.plugin.SimpleSkyWars;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SimpleActionManager
implements ActionManager {
	private final SimpleSkyWars plugin;
	private final Map<ActionContext, SimpleAction> actions;
	
	public SimpleActionManager(SimpleSkyWars plugin) {
		this.plugin = Objects.requireNonNull(plugin, "The SimpleSkyWars instance is null.");
		this.actions = new HashMap<>();
	}
	
	@Override
	public void register(ActionContext context, SimpleAction action) {
		actions.put(context, action);
	}
	
	@Override
	public void execute(Player player, String container) {
		actions.get(ActionContext.valueOf(StringUtils.substringBetween(container, "[", "]").toUpperCase()))
			 .execute(plugin, player, container.contains(" ")
				  ? container.split(" ", 2)[1]
				  : "");
	}
	
	@Override
	public void unregister(ActionContext context) {
		actions.remove(context);
	}
	
	@Override
	public void unregisterAll() {
		actions.clear();
	}
}
