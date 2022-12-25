package net.simpleskywars.plugin.utils;

import net.simpleskywars.plugin.SimpleSkyWars;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtils {
	private static final Logger LOGGER = SimpleSkyWars.getPlugin().getLogger();
	
	public LogUtils() {}
	
	private static boolean debugEnabled;
	
	public static boolean isDebugEnabled() {
		return debugEnabled;
	}
	
	public static void setDebugEnabled(boolean enable) {
		debugEnabled = enable;
	}
	
	public static void info(String... logs) {
		for (String logMessage : logs) {
			LOGGER.log(Level.INFO, logMessage);
		}
	}
	
	public static void warn(String... logs) {
		for (String logMessage : logs) {
			LOGGER.log(Level.WARNING, logMessage);
		}
	}
	
	public static void error(String... logs) {
		for (String logMessage : logs) {
			LOGGER.log(Level.SEVERE, logMessage);
		}
	}
}
