package couk.Adamki11s.Commands;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import couk.Adamki11s.Database.Initialise;
import couk.Adamki11s.Database.Preferences;
import couk.Adamki11s.Database.Statistics;
import couk.Adamki11s.Warzone.Warzone;

public class StatisticsCommands {
	
	DecimalFormat lvlFormat = new DecimalFormat("#0");
	Preferences pref = new Preferences();

	public void check(Player p, String[] args){
		
		if(args.length == 1 && (args[0].equalsIgnoreCase("leaderboard") || args[0].equalsIgnoreCase("leaderboards"))){
			ArrayList<Float> scores = new ArrayList<Float>();
			
			for(Map.Entry<String, Float> s : Statistics.playerScore.entrySet()){
				scores.add(s.getValue());
			}
			
			Collections.sort(scores);
			Collections.reverse(scores);	
			
			int rank = 0;
			
			boolean playershown = false;
			
			for(Float s : scores){
				rank++;
				for(Map.Entry<String, Float> sc : Statistics.playerScore.entrySet()){
					if(rank <= 10){
						if(rank == 10 && !playershown){
							p.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + rank + ChatColor.RED + "]" + ChatColor.BLUE + " Score : " + ChatColor.GREEN + s + " - " + ChatColor.RED + sc.getKey());
							break;
						}
						if(s == sc.getValue()){
							if(sc.getKey().equals(p.getName())){
								playershown = true;
								p.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + rank + ChatColor.RED + "]" + ChatColor.BLUE + " Score : " + ChatColor.GREEN + s + " - " + ChatColor.RED + sc.getKey());
							} else {
								p.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + rank + ChatColor.RED + "]" + ChatColor.BLUE + " Score : " + ChatColor.GOLD + s + " - " + ChatColor.BLUE + sc.getKey());
							}
						}
					}
				}
			}

			return;
		}
		
		if(args.length == 1 && args[0].equalsIgnoreCase("stats")){
			
			p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + p.getName() + "]");
			
			if(Statistics.gamesPlayed.get(p.getName()) > 0){
				NumberFormat formatter = new DecimalFormat("#0.000"), kdFormat = new DecimalFormat("#0.00");
				
				double shotsHit = Statistics.totalShotsHit.get(p.getName()), shotsFired = Statistics.totalShotsFired.get(p.getName()),
				wins = Statistics.totalGamesWon.get(p.getName()), losses = Statistics.totalGamesLost.get(p.getName()),
				kills = Statistics.totalKills.get(p.getName()), deaths = Statistics.totalDeaths.get(p.getName());
				int playtime = Statistics.totalTimePlayed.get(p.getName());
				
				double accuracy = Math.abs((double)(shotsHit / shotsFired));
				accuracy *= 100;
				double KDR = Math.abs((double)(kills / deaths)), WLR = Math.abs((double)(wins / losses));
				
				float points = Statistics.playerScore.get(p.getName());
				int level = Statistics.playerLevel.get(p.getName());
				String levelTitle = Statistics.levelTitles.get(level);

				p.sendMessage(ChatColor.DARK_AQUA + "Games Played : " + ChatColor.GREEN + Statistics.gamesPlayed.get(p.getName()));
				p.sendMessage(ChatColor.DARK_AQUA + "Level : " + ChatColor.GREEN + lvlFormat.format(level) + " - " + ChatColor.BLUE + levelTitle + " (" + lvlFormat.format(level) + "/50)");
				if(level < 50){
					p.sendMessage(ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points + " exp.");
					p.sendMessage(ChatColor.DARK_AQUA + "Exp to next level: " + ChatColor.GREEN + (Initialise.levels[level + 1] - Initialise.levels[level]));
				} else {
					p.sendMessage(ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points + " exp.");
				}
				p.sendMessage(ChatColor.DARK_AQUA + "Accuracy : " + ChatColor.GREEN + formatter.format(accuracy) + "%");
				p.sendMessage(ChatColor.DARK_AQUA + "Kill/Death Ratio : " + ChatColor.GREEN + kdFormat.format(KDR));
				p.sendMessage(ChatColor.DARK_AQUA + "Win/Loss Ratio : " + ChatColor.GREEN + kdFormat.format(WLR));
				if(playtime < 60){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + playtime + " seconds");
				} else if(playtime >= 60 && playtime < 3600){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + (playtime / 60) + " minutes");
				} else if(playtime >= 3600 && playtime < 86400){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + (playtime / 3600) + " hours");
				} else {
					double days = ((double)playtime / 86400.0);
					double remaining = ((double)playtime - (days * 86400.0));
					double hours = (remaining / 3600.0);
					double minsleft = ((remaining - (hours * 3600.0))/60.0);
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + days + " Days, " + hours + " Hours, " + minsleft + " Minutes.");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Error : " + ChatColor.GRAY + Warzone.li.getObj("You have no statistics to display!"));
			}
			
			p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + p.getName() + "]");

			return;
			
		} else if(args.length == 2 && args[0].equalsIgnoreCase("stats")){
			
			String name = args[1];
			
			p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + name + "]");
			
			if(Statistics.gamesPlayed.containsKey(name) && Statistics.gamesPlayed.get(name) > 0){
				NumberFormat formatter = new DecimalFormat("#0.000"), kdFormat = new DecimalFormat("#0.00");
				
				double shotsHit = Statistics.totalShotsHit.get(name), shotsFired = Statistics.totalShotsFired.get(name),
				wins = Statistics.totalGamesWon.get(name), losses = Statistics.totalGamesLost.get(name),
				kills = Statistics.totalKills.get(name), deaths = Statistics.totalDeaths.get(name);
				int playtime = Statistics.totalTimePlayed.get(name);
				
				double accuracy = Math.abs((double)(shotsHit / shotsFired));
				accuracy *= 100;
				double KDR = Math.abs((double)(kills / deaths)), WLR = Math.abs((double)(wins / losses));
				
				float points = Statistics.playerScore.get(name);
				int level = Statistics.playerLevel.get(name);
				String levelTitle = Statistics.levelTitles.get(level);

				p.sendMessage(ChatColor.DARK_AQUA + "Games Played : " + ChatColor.GREEN + Statistics.gamesPlayed.get(name));
				p.sendMessage(ChatColor.DARK_AQUA + "Level : " + ChatColor.GREEN + lvlFormat.format(level) + " - " + ChatColor.BLUE + levelTitle + " (" + lvlFormat.format(level) + "/50)");
				if(level < 50){
					p.sendMessage(ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points + " exp.");
					p.sendMessage(ChatColor.DARK_AQUA + "Exp to next level: " + ChatColor.GREEN + (Initialise.levels[level + 1] - Initialise.levels[level]));
				} else {
					p.sendMessage(ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points + " exp.");
				}
				p.sendMessage(ChatColor.DARK_AQUA + "Accuracy : " + ChatColor.GREEN + formatter.format(accuracy) + "%");
				p.sendMessage(ChatColor.DARK_AQUA + "Kill/Death Ratio : " + ChatColor.GREEN + kdFormat.format(KDR));
				p.sendMessage(ChatColor.DARK_AQUA + "Win/Loss Ratio : " + ChatColor.GREEN + kdFormat.format(WLR));
				if(playtime < 60){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + playtime + " seconds");
				} else if(playtime >= 60 && playtime < 3600){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + (playtime / 60) + " minutes");
				} else if(playtime >= 3600 && playtime < 86400){
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + (playtime / 3600) + " hours");
				} else {
					double days = ((double)playtime / 86400.0);
					double remaining = ((double)playtime - (days * 86400.0));
					double hours = (remaining / 3600.0);
					double minsleft = ((remaining - (hours * 3600.0))/60.0);
					p.sendMessage(ChatColor.DARK_AQUA + "Playtime : " + ChatColor.GREEN + days + " Days, " + hours + " Hours, " + minsleft + " Minutes.");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Error : " + ChatColor.DARK_AQUA + name + ChatColor.GRAY + " " +  Warzone.li.getObj("has no statistics to display."));
			}
			p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + name + "]");

			return;
			
		} else if(args.length == 3 && args[0].equalsIgnoreCase("stats")){
			
			String p1 = args[1], p2 = args[2];
			
			if(Statistics.gamesPlayed.containsKey(p1) && Statistics.gamesPlayed.get(p1) > 0){
				
				if(Statistics.gamesPlayed.containsKey(p2) && Statistics.gamesPlayed.get(p2) > 0){
					
					NumberFormat formatter = new DecimalFormat("#0.00"), kdFormat = new DecimalFormat("#0.00");
					
					double shotsHit1 = Statistics.totalShotsHit.get(p1), shotsFired1 = Statistics.totalShotsFired.get(p1),
					wins1 = Statistics.totalGamesWon.get(p1), losses1 = Statistics.totalGamesLost.get(p1),
					kills1 = Statistics.totalKills.get(p1), deaths1 = Statistics.totalDeaths.get(p1);
					
					double accuracy1 = Math.abs((double)(shotsHit1 / shotsFired1));
					accuracy1 *= 100;
					double KDR1 = Math.abs((double)(kills1 / deaths1)), WLR1 = Math.abs((double)(wins1 / losses1));
					
					double shotsHit2 = Statistics.totalShotsHit.get(p2), shotsFired2 = Statistics.totalShotsFired.get(p2),
					wins2 = Statistics.totalGamesWon.get(p2), losses2 = Statistics.totalGamesLost.get(p2),
					kills2 = Statistics.totalKills.get(p2), deaths2 = Statistics.totalDeaths.get(p2);
					
					double accuracy2 = Math.abs((double)(shotsHit2 / shotsFired2));
					accuracy2 *= 100;
					double KDR2 = Math.abs((double)(kills2 / deaths2)), WLR2 = Math.abs((double)(wins2 / losses2));
					
					float points1 = Statistics.playerScore.get(p1);
					int level1 = Statistics.playerLevel.get(p1);
					
					float points2 = Statistics.playerScore.get(p2);
					int level2 = Statistics.playerLevel.get(p2);
					
					p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + p1 + "]" + "[" + p2 + "]");
					
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "Games Played : " + ChatColor.GREEN + Statistics.gamesPlayed.get(p1) + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "Games Played : " + ChatColor.GREEN + Statistics.gamesPlayed.get(p2));
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "Level : " + ChatColor.GREEN + lvlFormat.format(level1) + " (" + lvlFormat.format(level1) + "/50)" + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "Level : " + ChatColor.GREEN + lvlFormat.format(level2) + " (" + lvlFormat.format(level2) + "/50)");
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points1 + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "Exp Gained : " + ChatColor.GREEN + (int)points2);
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "Accuracy : " + ChatColor.GREEN + formatter.format(accuracy1) + "%" + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "Accuracy : " + ChatColor.GREEN + formatter.format(accuracy2) + "%");
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "K/D Ratio : " + ChatColor.GREEN + kdFormat.format(KDR1) + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "K/D Ratio : " + ChatColor.GREEN + kdFormat.format(KDR2));
					p.sendMessage(ChatColor.GRAY + "[" + p1 + "] " + ChatColor.DARK_AQUA + "W/L Ratio : " + ChatColor.GREEN + kdFormat.format(WLR1) + ChatColor.GRAY + " [" + p2 + "] " + ChatColor.DARK_AQUA + "W/L Ratio : " + ChatColor.GREEN + kdFormat.format(WLR2));
				
					p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Statistics]" + ChatColor.GRAY + "[" + p1 + "]" + "[" + p2 + "]");
					
				} else {
					p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.DARK_AQUA + p2 + ChatColor.RED + " " + Warzone.li.getObj("has no statistics to display."));
					return;
				}
			} else {
				p.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.DARK_AQUA + p1 + ChatColor.RED + " " +  Warzone.li.getObj("has no statistics to display."));
				return;
			}
			return;
		}
	}
	
}
