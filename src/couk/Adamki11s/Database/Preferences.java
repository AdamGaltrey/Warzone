package couk.Adamki11s.Database;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.config.Configuration;

import couk.Adamki11s.Extras.Player.ExtrasPlayer;
import couk.Adamki11s.Warzone.Warzone;

public class Preferences {
	
	public static HashMap<String, Armour> armourType = new HashMap<String, Armour>();
	public static HashMap<String, ItemStack> blockHead = new HashMap<String, ItemStack>();
	public static HashMap<String, Material> swordType = new HashMap<String, Material>();
	
	File root = new File("plugins/Warzone/Preferences");
	
	public boolean doesPlayerHavePreferenceFile(String name){
		File pPref = new File(root + File.separator + name + ".pref");
		if(pPref.exists()){
			return true;
		} else {
			return false;
		}
	}
	
	public void createPreferenceFile(String name){
		File pref = new File(root + File.separator + name + ".pref");
		Configuration c = new Configuration(pref);
		if(!doesPlayerHavePreferenceFile(name)){
			try {
				pref.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			c.setProperty("Preferences.ArmourType", "NONE");
			c.setProperty("Preferences.BlockOnHead", "AIR");
			c.setProperty("Preferences.Sword", Material.WOOD_SWORD.toString());
			c.save();
		}
	}
	
	public void loadPreferences(String name){
		File pref = new File(root + File.separator + name + ".pref");
		Configuration c = new Configuration(pref);
		c.load();
		armourType.put(name.toString(), getArmour(c.getString("Preferences.ArmourType", "NONE")));
		blockHead.put(name.toString(), new ItemStack((Material.getMaterial(c.getString("Preferences.BlockOnHead", "AIR"))), 1));
		swordType.put(name.toString(), Material.getMaterial(c.getString("Preferences.Sword", Material.WOOD_SWORD.toString())));
	}
	
	ExtrasPlayer ep = new ExtrasPlayer();
	
	public void modifySwordType(Player p, String sword){
		int level = Statistics.playerLevel.get(p.getName());
		File pref = new File(root + File.separator + p.getName() + ".pref");
		Configuration c = new Configuration(pref);
		Material m = Material.getMaterial(sword);
		if(sword.equalsIgnoreCase("wood") || sword.equalsIgnoreCase("wooden")){
			m = Material.WOOD_SWORD;
		} else if(sword.equalsIgnoreCase("iron")){
			m = Material.IRON_SWORD;
		} else if(sword.equalsIgnoreCase("gold") || sword.equalsIgnoreCase("golden")){
			m = Material.GOLD_SWORD;
		} else if(sword.equalsIgnoreCase("diamond")){
			m = Material.DIAMOND_SWORD;
		}
		if(m != Material.WOOD_SWORD && m != Material.IRON_SWORD && m != Material.GOLD_SWORD && m!= Material.DIAMOND_SWORD){
			p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("Invalid Sword Type") + "! WOOD, IRON, GOLD, DIAMOND only!");
			return;
		} else {			
			if(m == Material.WOOD_SWORD && level < 10){
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + "10" + Warzone.li.getObj("or above to do this") + "!");
				return;
			} else if(m == Material.IRON_SWORD && level < 20){
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + "20" + Warzone.li.getObj("or above to do this") + "!");
				return;
			} else if(m == Material.GOLD_SWORD && level < 30){
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + "30" + Warzone.li.getObj("or above to do this") + "!");
				return;
			} else if(m == Material.DIAMOND_SWORD && level < 40){
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + "40" + Warzone.li.getObj("or above to do this") + "!");
				return;
			} 
			
			c.load();
			c.setProperty("Preferences.BlockOnHead", c.getString("Preferences.BlockOnHead", "AIR"));
			c.setProperty("Preferences.ArmourType", c.getString("Preferences.ArmourType", "NONE"));
			c.setProperty("Preferences.Sword", m.toString());
			c.save();
			
			swordType.put(p.getName().toString(), m);
			
			p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("Sword preference changed to") + " " + ChatColor.BLUE + m.toString());
		}
	}
	
	public void modifyBlockOnHead(Player p, int material){
		int level = Statistics.playerLevel.get(p.getName());
		File pref = new File(root + File.separator + p.getName() + ".pref");
		Configuration c = new Configuration(pref);
		c.load();
		Material m = Material.getMaterial(material);
		if(level >= 40){
			if(m == null || m == Material.AIR){			
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("Invalid Material Type!"));
				return;
			}
			c.setProperty("Preferences.ArmourType", c.getString("Preferences.ArmourType", "NONE"));
			c.setProperty("Preferences.BlockOnHead", c.getString("Preferences.BlockOnHead", m.toString().toUpperCase()));
			c.setProperty("Preferences.Sword", c.getString("Preferences.Sword", Material.WOOD_SWORD.toString()));
			blockHead.put(p.getName(), new ItemStack(m, 1));
			p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + "Block preference changed to " + ChatColor.DARK_AQUA + m.toString().toUpperCase() + ChatColor.GREEN + " successfully!");
			c.save();
		} else {
			p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + "40" + Warzone.li.getObj("or above to do this") + "!");
			return;
		}
	}
	
	public void modifyArmourPreference(Player p, Armour a){
		int level = Statistics.playerLevel.get(p.getName());
		File pref = new File(root + File.separator + p.getName() + ".pref");
		Configuration c = new Configuration(pref);
		c.load();
		if(a != null){
			boolean canusearmour = false;
			int l = 0;
			switch(a){
			case LEATHER: if(level >= 10){
				canusearmour = true;
				break;
			} else {
				l = 10;
				break;
			}
			case IRON: if(level >= 20){
				canusearmour = true;
				break;
			} else {
				l = 20;
				break;
			}
			case GOLD: if(level >= 30){
				canusearmour = true;
				break;
			} else {
				l = 30;
				break;
			}
			case DIAMOND: if(level >= 40){
				canusearmour = true;
				break;
			} else {
				l = 40;
				break;
			}
			}
			
			if(canusearmour){
				c.setProperty("Preferences.ArmourType", a.toString());
				c.setProperty("Preferences.BlockOnHead", c.getString("Preferences.BlockOnHead", "AIR"));
				c.setProperty("Preferences.Sword", c.getString("Preferences.Sword", Material.WOOD_SWORD.toString()));
				c.save();
				p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.GREEN + " " + Warzone.li.getObj("Armour type changed to") + " " + ChatColor.DARK_AQUA + a.toString() + ChatColor.GREEN + " " + Warzone.li.getObj("sucessfully!"));
				armourType.put(p.getName(), a);
			} else {
				p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must be level") + " " + ChatColor.DARK_AQUA + l + ChatColor.RED + " " + Warzone.li.getObj("to wield this armour!"));
			}
		} else {
			p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("Error : Armour type can only be") + " NONE, LEATHER,    IRON, GOLD or DIAMOND.");
			return;
		}
	}
	
	public Armour getArmour(String s){
		if(s.equalsIgnoreCase("NONE")){
			return Armour.NONE;
		} else if(s.equalsIgnoreCase("LEATHER")){
			return Armour.LEATHER;
		} else if(s.equalsIgnoreCase("IRON")){
			return Armour.IRON;
		} else if(s.equalsIgnoreCase("GOLD")){
			return Armour.GOLD;
		} else if(s.equalsIgnoreCase("DIAMOND")){
			return Armour.DIAMOND;
		}
		return null;
	}
	
	public enum Armour{
		
		NONE,
		LEATHER,
		IRON,
		GOLD,
		DIAMOND;
		
		@Override
		public String toString(){
			return super.toString().toUpperCase();
		}
	
	}

}
