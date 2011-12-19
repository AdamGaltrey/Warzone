package couk.Adamki11s.Commands;

import java.net.MalformedURLException;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import couk.Adamki11s.Database.Initialise;
import couk.Adamki11s.Database.PermissionsCore;
import couk.Adamki11s.Database.Statistics;
import couk.Adamki11s.Warzone.Warzone;

public class AdminCommands {
	
	PermissionsCore pc = new PermissionsCore();
	
	public void check(Player p, String[] args){
		
		if(args.length == 1 && args[0].equalsIgnoreCase("disable")){
			if(pc.doesHaveSuperNode(p, "warzone.admin.disable")){
				Warzone.server.getPluginManager().disablePlugin(Warzone.plugin);
				p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GRAY + " " + Warzone.li.getObj("Warzone disabled successfully") + "!");
				return;
			} else {
				pc.sendInsufficientPermsMsg(p);
				return;
			}
		}
		
		if(args.length == 2 && args[0].equalsIgnoreCase("reset")){
			if(pc.doesHaveSuperNode(p, "warzone.admin.reset")){
				if(Statistics.databaseHoldings.contains(args[1])){
					if(!Initialise.mysqlEnabled){
						String delP = "UPDATE statistics SET wins=1, draws=1, losses=1, shotsfired=1, shotshit=1, shotsmissed=1, kills=1, deaths=1, playtime=0, gp=0 WHERE player='" +
									args[1] + "';";
						Initialise.core.updateQuery(delP);
					} else {
						String delP = "UPDATE statistics SET wins=1, draws=1, losses=1, shotsfired=1, shotshit=1, shotsmissed=1, kills=1, deaths=1, playtime=0, gp=0 WHERE player='" +
						args[1] + "';";
						try {
							Initialise.sqlCore.updateQuery(delP);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (InstantiationException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
					p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("Statistics reset for player : ") + ChatColor.BLUE + args[1]);
					return;
				} else {
					p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("This player does not exist in the warzone database!"));
					return;
				}
			} else {
				pc.sendInsufficientPermsMsg(p);
				return;
			}
		}
		
	}

}
