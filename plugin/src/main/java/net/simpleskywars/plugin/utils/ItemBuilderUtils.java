package net.simpleskywars.plugin.utils;

import com.google.common.base.Preconditions;
import net.xconfig.bukkit.utils.TextUtils;
import net.xtitle.lib.XTitle;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class ItemBuilderUtils {
	private ItemBuilderUtils() {}
	
	public static class Builder {
		private final Material material;
		
		private int amount;
		private String displayName;
		private String lore;
		
		public Builder(Material material) {
			this.material = Objects.requireNonNull(material, "The material enum is null.");
		}
		
		public Builder amount(int amount) {
			this.amount = amount;
			return this;
		}
		
		public Builder displayName(String displayName) {
			this.displayName = TextUtils.colorize(Objects.requireNonNull(displayName, "The display name is null."));
			Preconditions.checkArgument(!displayName.isEmpty(), "The display name is empty.");
			return this;
		}
		
		public Builder lore(String lore) {
			this.lore = TextUtils.colorize(Objects.requireNonNull(lore, "The lore is null."));
			Preconditions.checkArgument(!lore.isEmpty(), "The lore is empty.");
			return this;
		}
		
		@SuppressWarnings("deprecation")
		public ItemStack build() {
			if (amount <= 0) amount = 1;
			
			if (displayName == null) throw new IllegalArgumentException("The item display name isn't established.");
			
			if (lore == null) throw new IllegalArgumentException("The item lore isn't established.");
			
			ItemStack item = new ItemStack(material, amount);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName(displayName);
			meta.setLore(Arrays.asList(lore.split("\n")));
			
			if (XTitle.canSupport(13)) meta.setUnbreakable(true);
			else meta.spigot().setUnbreakable(true);
			
			item.setItemMeta(meta);
			return item;
		}
	}
}
