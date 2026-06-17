package me.datatags.constanthunger.util;

import org.bukkit.ChatColor;


public class ColorUtil {


	public static String translate(String message) {
		if (message == null) {
			return "";
		}
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}