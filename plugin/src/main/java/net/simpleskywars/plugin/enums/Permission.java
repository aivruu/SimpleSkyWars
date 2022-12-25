package net.simpleskywars.plugin.enums;

public enum Permission {
	HELP_CMD ("simpleskywars.help"),
	RELOAD_CMD ("simpleskywars.reload"),
	SW_JOIN_CMD ("simpleskywars.sw.join"),
	GAME_ADMIN_CMD ("simpleskywars.sw.game"),
	SW_ADMIN_CMD ("simpleskywars.sw.admin");
	
	private final String permission;
	
	Permission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
}
