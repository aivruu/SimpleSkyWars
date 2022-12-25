package net.simpleskywars.plugin.utils;

import com.google.common.base.Preconditions;
import net.simpleskywars.plugin.SimpleSkyWars;
import net.xconfig.bukkit.utils.TextUtils;
import net.xtitle.api.TitleManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils {
	private static final TitleManager TITLE_MANAGER = SimpleSkyWars.getPlugin().getTitleManager();
	
	public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
		Preconditions.checkArgument(!title.isEmpty(), "The title message is empty.");
		Preconditions.checkArgument(!subtitle.isEmpty(), "The subtitle message is empty.");
		
		TITLE_MANAGER.sendTitle(player, fadeIn, stay, fadeOut, TextUtils.colorize(title), TextUtils.colorize(subtitle));
	}
	
	public static void clearTitle(Player player) {
		TITLE_MANAGER.clearTitle(player);
	}
	
	public static void sendActionBar(JavaPlugin plugin, Player player, String message, long duration) {
		Preconditions.checkNotNull(plugin, "The JavaPlugin instance is null.");
		Preconditions.checkArgument(!message.isEmpty(), "The actionbar message is empty.");
		
		TITLE_MANAGER.sendActionBar(plugin, player, TextUtils.colorize(message), duration);
	}
}
