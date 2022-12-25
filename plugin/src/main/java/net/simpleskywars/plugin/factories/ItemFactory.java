package net.simpleskywars.plugin.factories;

import net.simpleskywars.plugin.utils.ItemBuilderUtils;
import org.bukkit.Material;

public interface ItemFactory {
	static ItemBuilderUtils.Builder fromMaterial(Material material) {
		return new ItemBuilderUtils.Builder(material);
	}
}
