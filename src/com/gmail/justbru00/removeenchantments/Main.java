package com.gmail.justbru00.removeenchantments;

import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	public static Logger logger = Bukkit.getLogger();
	public static String prefix = Messager.color("&8[&bRemove&fEnchantments&8] &6");

	@Override
	public void onDisable() {
		Messager.msgConsole("&cDisabling plugin...");
	}

	@Override
	public void onEnable() {
		Messager.msgConsole("&aStarting plugin...");
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (command.getName().equalsIgnoreCase("removeenchantments")) {
			
			if (sender instanceof Player) {
				if (sender.hasPermission("removeenchantments.removeenchantments")) {
					
					Player p = (Player) sender;
					
					
					ItemStack is = p.getItemInHand();
					
					if (is == null) {
						Messager.msgPlayer("&cYou cannot remove enchantments from nothing.", p);
						return true;
					}
					
					ItemMeta im = is.getItemMeta();
					
					Map<Enchantment, Integer> enchants = im.getEnchants();
					
					im.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
					
					for (Enchantment e : enchants.keySet())	 {
						im.removeEnchant(e);
					}
					
					is.setItemMeta(im);
					
					p.getInventory().setItemInHand(is);
					
					Messager.msgPlayer("&aRemoved Enchantments.", p);
					
					return true;
					
				} else {
					Messager.msgSender("&cYou don't have permission. (removeenchantments.removeenchantments)", sender);
					return true;
				}
			} else {
				Messager.msgSender("&cOnly players can use this command.", sender);
				return true;
			}
			
		}
		
		return false;
	}
	
	

	
	
}
