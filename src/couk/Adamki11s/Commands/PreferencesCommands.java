package couk.Adamki11s.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import couk.Adamki11s.Database.PermissionsCore;
import couk.Adamki11s.Database.Preferences;
import couk.Adamki11s.Database.Preferences.Armour;
import couk.Adamki11s.Warzone.Warzone;

public class PreferencesCommands {
	
	Preferences pref = new Preferences();
	PermissionsCore pc = new PermissionsCore();
	
	public void check(Player p, String[] args){
		if(args.length >= 2 && (args[0].equalsIgnoreCase("prefs") || args[0].equalsIgnoreCase("preferences"))){
			if(pc.doesHaveNode(p, "warzone.misc.prefs")){
				if(args[1].equalsIgnoreCase("armour")){
					Armour a = pref.getArmour(args[2].toString());
					pref.modifyArmourPreference(p, a);
					return;
				}
				if(args[1].equalsIgnoreCase("sword")){
					pref.modifySwordType(p, args[2].toString());
				}
				if(args[1].equalsIgnoreCase("blockhead") || args[1].equalsIgnoreCase("block")){
					int id = 0;
					try{
						id = Integer.parseInt(args[2]);
					} catch (NumberFormatException ex){
						p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You must provide the block id!"));
						return;
					}
					pref.modifyBlockOnHead(p, id);
					return;
				}
			} else {
				pc.sendInsufficientPermsMsg(p);
				return;
			}
		}
	}

}
