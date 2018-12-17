/**
 * @author Justin "JustBru00" Brubaker
 * 
 * This is licensed under the MPL Version 2.0. See license info in LICENSE.txt
 */ 
package com.gmail.justbru00.removeenchantments;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * 
 * @author Justin Brubaker
 *
 */
public class Messager {	


	public static String color(String uncolored){
		return ChatColor.translateAlternateColorCodes('&', uncolored);		
	}
	
	public static void msgConsole(String msg) {				
		if (Main.console != null) {
		Main.console.sendMessage(Main.prefix + Messager.color(msg));		
		} else {
			Main.logger.info(ChatColor.stripColor(Messager.color(msg)));
		}
	}
	
	public static void msgPlayer(String msg, Player player) {		
		player.sendMessage(Main.prefix + Messager.color(msg));
	}	
	
	public static void msgSender(String msg, CommandSender sender) {		
		sender.sendMessage(Main.prefix + Messager.color(msg));
	}	
}
