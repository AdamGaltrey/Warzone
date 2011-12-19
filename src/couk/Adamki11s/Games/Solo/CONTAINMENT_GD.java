package couk.Adamki11s.Games.Solo;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import couk.Adamki11s.Database.CoreConfiguration;
import couk.Adamki11s.Database.Initialise;
import couk.Adamki11s.Database.Preferences;
import couk.Adamki11s.Database.Statistics;
import couk.Adamki11s.Extras.Inventory.ExtrasInventory;
import couk.Adamki11s.Extras.Player.ExtrasPlayer;
import couk.Adamki11s.Lobby.SoloPool;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.Warzone.Warzone;
import couk.Adamki11s.Warzone.Warzone.GameType;
import couk.Adamki11s.Warzone.Warzone.MapName;

public class CONTAINMENT_GD extends Gamedata {
	public static int gameTime;

	HashMap<Player, Integer> score = new HashMap<Player, Integer>();
	HashMap<Player, Integer> shotsHit = new HashMap<Player, Integer>();
	HashMap<Player, Integer> shotsFired = new HashMap<Player, Integer>();
	HashMap<Player, Integer> shotsMissed = new HashMap<Player, Integer>();
	
	HashMap<Player, Location> previousLocation = new HashMap<Player, Location>();
	
	ExtrasInventory inventmanage = new ExtrasInventory();
	
	HashMap<Player, ItemStack[]> invent = new HashMap<Player, ItemStack[]>();
	HashMap<Player, ItemStack[]> inventArmour = new HashMap<Player, ItemStack[]>();
	
	HashMap<Player, Integer> kills = new HashMap<Player, Integer>();
	HashMap<Player, Integer> deaths = new HashMap<Player, Integer>();
	
	private HashMap<Player, Integer> virtualHealth = new HashMap<Player, Integer>();
	
	private Location sign1 = new Location(Maps.Warzone_World, 152.30000000000001D, 64.620000000000005D, -165.5D);
	private Location sign2 = new Location(Maps.Warzone_World, 240.30000000000001D, 52.619999999999997D, -53.5D);
	
	Sign s1 = (Sign)Maps.Warzone_World.getBlockAt(sign1).getState();
	Sign s2 = (Sign)Maps.Warzone_World.getBlockAt(sign2).getState();
	
	private static int timer = 0;
	
	private boolean playerQuit = false;
	
	private GameType gametype;
	
	ArrayList<Player> participants = new ArrayList<Player>();
	
	@Override
	public void passGameType(GameType gt){
		gametype = gt;
	}

	@Override
	public void initiateGame(ArrayList<Player> list) {
		timer = 0;
		playerQuit = false;
		for(Player p : list){
			kills.put(p, 0);
			deaths.put(p, 0);
			score.put(p, 0);
			shotsHit.put(p, 0);
			shotsFired.put(p, 0);
			shotsMissed.put(p, 0);
			virtualHealth.put(p, 5);
		}
		s1.setLine(0, ChatColor.DARK_GREEN + "YOU : 0");
		s1.setLine(1, ChatColor.RED + "THEM : 0");
		s1.setLine(2, ChatColor.DARK_PURPLE + Warzone.li.getObj("Time Left"));
		s1.setLine(3, ChatColor.DARK_PURPLE + "" + (gameTime - timer));
		s2.setLine(0, ChatColor.DARK_GREEN + "YOU : 0");
		s2.setLine(1, ChatColor.RED + "THEM : 0");
		s2.setLine(2, ChatColor.DARK_PURPLE + Warzone.li.getObj("Time Left"));
		s2.setLine(3, ChatColor.DARK_PURPLE + "" + (gameTime - timer));
		s1.update();
		s2.update();
	}
	
	@Override
	public void addParticipant(Player p) {
		Initialise.pushStatistics(p);
		participants.add(p);
		previousLocation.put(p, SoloPool.locs.get(p));
		invent.put(p, p.getInventory().getContents());
		inventArmour.put(p, p.getInventory().getArmorContents());
	}

	@Override
	public void removeParticipants(Player p) {
		participants.remove(p);
	}

	@Override
	public void shotFired(Player p) {
		shotsFired.put(p, shotsFired.get(p) + 1);
	}

	@Override
	public void shotMissed(Player p) {
		shotsMissed.put(p, shotsMissed.get(p) + 1);
	}
	
	@Override
	public void swordStruck(Player p, Player target){
		kills.put(p, kills.get(p) + 1);
		deaths.put(target, deaths.get(target) + 1);
		Warzone.ec.sendColouredMessage(p, "&red[Warzone] &a" + Warzone.li.getObj("You struckdown") + " &9" + target.getName() + "!");
		Warzone.ec.sendColouredMessage(target, "&red[Warzone] &a" + Warzone.li.getObj("You got struckdown by") + " &9" + p.getName() + "!");
		virtualHealth.put(target, 5);
		virtualHealth.put(p, 5);
		incrementPlayerScore(p);
		respawn();
	}

	@Override
	public void shotHit(Player p, Player target) {
		shotsHit.put(p, shotsHit.get(p) + 1);
		virtualHealth.put(target, virtualHealth.get(target) - 1);
		target.damage(1);
		
		if(virtualHealth.get(target) <= 0){
			kills.put(p, kills.get(p) + 1);
			deaths.put(target, deaths.get(target) + 1);
			Warzone.ec.sendColouredMessage(p, "&red[Warzone] &a" + Warzone.li.getObj("You shot") + " &9" + target.getName() + "!");
			Warzone.ec.sendColouredMessage(target, "&red[Warzone] &a" + Warzone.li.getObj("You got shot by") + " &9" + p.getName() + "!");
			virtualHealth.put(target, 5);
			virtualHealth.put(p, 5);
			incrementPlayerScore(p);
			respawn();
		}
	}

	@Override
	public void incrementPlayerScore(Player p) {
		score.put(p, score.get(p) + 1);
	}

	@Override
	public Player getWinner() {
		int index = 0, score = 0, count = 0;
		for(Player p : participants){
			count++;
			if(this.score.get(p) > score){
				score = this.score.get(p);
				index = (count - 1);
			}
		}
		return participants.get(index);
	}
	
	@Override
	public Player getLooser() {
		int index = 0, score = 1584635, count = 0;
		for(Player p : participants){
			count++;
			if(this.score.get(p) < score){
				score = this.score.get(p);
				index = (count - 1);
			}
		}
		return participants.get(index);
	}

	@Override
	public String getName() {
		return "CONTAINMENT";
	}

	@Override
	public void tickerTask(int schedulerTask) {
		Player quitter = null;
		if(Warzone.server.getPlayer(participants.get(0).getName()) == null){
			timer = gameTime;
			playerQuit = true;
			score.put(participants.get(0), 0);
			score.put(participants.get(1), score.get(participants.get(1)) + 1);
			if(Warzone.server.getPlayer(participants.get(1).getName()) != null){
				quitter = participants.get(0);
				participants.get(1).sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.YELLOW + participants.get(0).getName()
						+ ChatColor.RED + " " + Warzone.li.getObj("Quit the game!"));
			}
			endGame(schedulerTask);
		} else if(Warzone.server.getPlayer(participants.get(1).getName()) == null){
			timer = gameTime;
			playerQuit = true;
			score.put(participants.get(1), 0);
			score.put(participants.get(0), score.get(participants.get(0)) + 1);
			if(Warzone.server.getPlayer(participants.get(0).getName()) != null){
				quitter = participants.get(1);
				participants.get(0).sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.YELLOW + participants.get(1).getName()
						+ ChatColor.RED + " " + Warzone.li.getObj("Quit the game!"));
			}
			endGame(schedulerTask);
		} else {
			timer++;
			if((timer % 10) == 0){
				for(Player pp : participants){
					if(virtualHealth.get(pp) < 5){
						virtualHealth.put(pp, virtualHealth.get(pp) + 1);
					}
				}
			}
			if((((timer - 1) % 60) == 0) && (timer < gameTime - 50)){
				for(Player p : participants){
					p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Timer]" + ChatColor.GREEN + " " + ((Math.round(gameTime - timer) / 60) + 1) + " minute(s) " + Warzone.li.getObj("remaining."));
				}
			} else if(((gameTime - timer) < 10) && ((timer >= (gameTime - 10)) && (timer <= gameTime) )){
				for(Player p : participants){
					p.sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.YELLOW + "[Timer]" + ChatColor.GREEN + " " + (gameTime - timer) + " second(s) " + Warzone.li.getObj("remaining."));
				}		
			}
		}
		if(timer > gameTime){
			endGame(schedulerTask);
		}
		s1.setLine(2, ChatColor.DARK_PURPLE + Warzone.li.getObj("Time Left"));
		s2.setLine(2, ChatColor.DARK_PURPLE + Warzone.li.getObj("Time Left"));
		s1.setLine(3, ChatColor.DARK_PURPLE + "" + (gameTime - timer));
		s2.setLine(3, ChatColor.DARK_PURPLE + "" + (gameTime - timer));
		s1.update();
		s2.update();
		
		if(playerQuit && quitter != null){
			Warzone.inventData.checkFile(quitter);
			Warzone.inventData.saveInventory(quitter, invent.get(quitter));
			int playTime = Statistics.totalTimePlayed.get(quitter.getName()) + gameTime;
			int loss = Statistics.totalGamesLost.get(quitter.getName()) + 1;
			if(gametype == GameType.RANKED){
				if(!Initialise.mysqlEnabled){
					String updateStats = "UPDATE statistics SET playtime='" + playTime + "'" +
					", losses='" + loss + "' WHERE player='" + quitter.getName() + "';";
					Initialise.core.updateQuery(updateStats);
				} else {
					String updateStats = "UPDATE statistics SET playtime='" + playTime + "'" +
					", losses='" + loss + "' WHERE player='" + quitter.getName() + "';";
					try {
						Initialise.sqlCore.updateQuery(updateStats);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			
			if(!Warzone.quitterHandle.doesExist(quitter)){
				Warzone.quitterHandle.addQuitter(quitter, previousLocation.get(quitter));
			} else {
				try {
					throw new Exception("[Warzone] Quitter file already exists when it shouldn't!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Float getPlayerScore(int shotshit, int kills, int deaths) {
		/*
		 * Win = +500
		 * Draw = +200
		 * Loss = +50
		 * ShotHit = +5
		 * Kill = +30
		 * Death = +5
		 */
		Float score = (float) 0;
		score += (shotshit * 5);
		score += (kills * 30);
		score += (deaths * 5);
		return score;
	}
	
	@Override public void endGame(int taskid){
		Player winner = getWinner();
		
		if(score.get(participants.get(0)) == score.get(participants.get(1))){
			participants.get(0).sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.GREEN + " " + Warzone.li.getObj("The match was a draw!"));
			participants.get(1).sendMessage(ChatColor.RED + "[Warzone]" + ChatColor.GREEN + " " + Warzone.li.getObj("The match was a draw!"));
			wasDraw = true;
			for(Player part : participants){
				part.teleport(previousLocation.get(part));
				
				inventmanage.wipeInventory(part);
				part.getInventory().setContents(invent.get(part));
				part.getInventory().setArmorContents(inventArmour.get(part));	
				inventmanage.sortInventory(part);
				if(gametype == GameType.RANKED){
					part.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("You gained") + " " + ChatColor.DARK_AQUA + (getPlayerScore(shotsHit.get(part), kills.get(part), deaths.get(part)) + 250) + ChatColor.GREEN + " exp!");
				}
			}
		} else {
			for(Player part : participants){
				part.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("Game over!"));
				part.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GOLD + winner.getName() + ChatColor.GREEN + " " + Warzone.li.getObj("was victorious!"));
				part.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GOLD + winner.getName() + ChatColor.GREEN + " " + Warzone.li.getObj("won with") + " " + ChatColor.BLUE + score.get(winner) +
						ChatColor.GREEN + " kills to " + ChatColor.BLUE + score.get(getLooser()) + ChatColor.GREEN + " " + Warzone.li.getObj("kills."));
				if(gametype == GameType.RANKED){
					if(getLooser() == part){
						part.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("You gained") + " " + ChatColor.DARK_AQUA + (getPlayerScore(shotsHit.get(part), kills.get(part), deaths.get(part)) + 50) + ChatColor.GREEN + " exp!");
					} else if(getWinner() == part){
						part.sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("You gained") + " " + ChatColor.DARK_AQUA + (getPlayerScore(shotsHit.get(part), kills.get(part), deaths.get(part)) + 500) + ChatColor.GREEN + " exp!");
					}
				}
				
				part.teleport(previousLocation.get(part));
				
				inventmanage.wipeInventory(part);
				part.getInventory().setContents(invent.get(part));
				part.getInventory().setArmorContents(inventArmour.get(part));	
				inventmanage.sortInventory(part);
			}
		}
		if(gametype == GameType.RANKED){
			saveData(participants);
		}
		participants.clear();
		shotsHit.clear();
		shotsFired.clear();
		shotsMissed.clear();
		timer = 0;
		Warzone.mapList.get(MapName.CONTAINMENT).setOccupiedState(false);
		Warzone.server.getScheduler().cancelTask(taskid);
	}
	
	public static boolean wasDraw = false;
	
	@Override public void saveData(ArrayList<Player> partic){
		if(!Initialise.mysqlEnabled){
			for(Player p : partic){
				int fired = Statistics.totalShotsFired.get(p.getName()) + shotsFired.get(p);
				int hit = Statistics.totalShotsHit.get(p.getName()) + shotsHit.get(p);
				int missed = Statistics.totalShotsMissed.get(p.getName()) + (fired - hit);
				int playTime = Statistics.totalTimePlayed.get(p.getName()) + gameTime;
				int won = Statistics.totalGamesWon.get(p.getName()) + 1;
				int loss = Statistics.totalGamesLost.get(p.getName()) + 1;
				int drew = Statistics.totalGamesDrawn.get(p.getName()) + 1;
				int gp = Statistics.gamesPlayed.get(p.getName()) + 1;
				int kill = Statistics.totalKills.get(p.getName()) + kills.get(p);
				int death = Statistics.totalDeaths.get(p.getName()) + deaths.get(p);
				String updateStats = "";
				if(!playerQuit){
					if(wasDraw){
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
								", draws='" + drew + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					} else if(getWinner() == p){
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", wins='" + won + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					} else {
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", losses='" + loss + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					}
					Initialise.core.updateQuery(updateStats);
				} else {
					if(Warzone.server.getPlayer(p.getName()) == null){
					
					} else {
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", wins='" + won + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					}
					Initialise.core.updateQuery(updateStats);
				}
				
				Initialise.pushStatistics(p);
			}
		} else {
			for(Player p : partic){
				int fired = Statistics.totalShotsFired.get(p.getName()) + shotsFired.get(p);
				int hit = Statistics.totalShotsHit.get(p.getName()) + shotsHit.get(p);
				int missed = Statistics.totalShotsMissed.get(p.getName()) + (fired - hit);
				int playTime = Statistics.totalTimePlayed.get(p.getName()) + gameTime;
				int won = Statistics.totalGamesWon.get(p.getName()) + 1;
				int loss = Statistics.totalGamesLost.get(p.getName()) + 1;
				int drew = Statistics.totalGamesDrawn.get(p.getName()) + 1;
				int gp = Statistics.gamesPlayed.get(p.getName()) + 1;
				int kill = Statistics.totalKills.get(p.getName()) + kills.get(p);
				int death = Statistics.totalDeaths.get(p.getName()) + deaths.get(p);
				String updateStats = "";
				if(!playerQuit){
					if(wasDraw){
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
								", draws='" + drew + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					} else if(getWinner() == p){
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", wins='" + won + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					} else {
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", losses='" + loss + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					}
					try {
						Initialise.sqlCore.updateQuery(updateStats);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if(Warzone.server.getPlayer(p.getName()) == null){
					
					} else {
						updateStats = "UPDATE statistics SET shotsfired='" + fired + "', shotshit='" + hit + "', shotsmissed='" + missed + "', playtime='" + playTime + "'" +
						", wins='" + won + "', kills='" + kill + "', deaths='" + death + "', gp='" + gp + "' WHERE player='" + p.getName() + "';";
					}
					try {
						Initialise.sqlCore.updateQuery(updateStats);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Initialise.pushStatistics(p);
			}
		}
	}

	@Override
	public ArrayList<Player> getParticipants() {
		return participants;
	}

	Preferences pref = new Preferences();
	ExtrasPlayer ep = new ExtrasPlayer();

	@SuppressWarnings("static-access")
	@Override
	public void respawn() {
		participants.get(0).teleport(Warzone.mapList.get(MapName.CONTAINMENT).getSpawnPoints().get(0));
		participants.get(1).teleport(Warzone.mapList.get(MapName.CONTAINMENT).getSpawnPoints().get(1));


		participants.get(0).setHealth(20);
		participants.get(1).setHealth(20);

		inventmanage.wipeInventory(participants.get(0));
		inventmanage.wipeInventory(participants.get(1));

		Player p1 = participants.get(0), p2 = participants.get(1);
		
		switch(pref.armourType.get(participants.get(0).getName())){
		case NONE: break;
		case LEATHER:
		p1.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
		p1.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
		p1.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
		p1.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
		break;
		case IRON:
		p1.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
		p1.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
		p1.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
		p1.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
		break;
		case GOLD:
		p1.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
		p1.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
		p1.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
		p1.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
		break;
		case DIAMOND:
		p1.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
		p1.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
		p1.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
		p1.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
		break;
		}
		
		switch(pref.armourType.get(participants.get(1).getName())){
		case NONE: break;
		case LEATHER:
		p2.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET, 1));
		p2.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
		p2.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS, 1));
		p2.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS, 1));
		break;
		case IRON:
		p2.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET, 1));
		p2.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE, 1));
		p2.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS, 1));
		p2.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS, 1));
		break;
		case GOLD:
		p2.getInventory().setHelmet(new ItemStack(Material.GOLD_HELMET, 1));
		p2.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE, 1));
		p2.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS, 1));
		p2.getInventory().setBoots(new ItemStack(Material.GOLD_BOOTS, 1));
		break;
		case DIAMOND:
		p2.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
		p2.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
		p2.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
		p2.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
		break;
		}
		
		if(pref.blockHead.get(p1.getName()).getType() != Material.AIR){
			p1.getInventory().setHelmet(null);
			ep.setBlockOnPlayerHead(p1, pref.blockHead.get(p1.getName()).getType());
		}

		if(pref.blockHead.get(p2.getName()).getType() != Material.AIR){
			p2.getInventory().setHelmet(null);
			ep.setBlockOnPlayerHead(p2, pref.blockHead.get(p2.getName()).getType());
		}
		
		inventmanage.addToInventory(participants.get(0), 261, 1);
		inventmanage.addToInventory(participants.get(1), 261, 1);

		inventmanage.addToInventory(participants.get(0), 262, 64);
		inventmanage.addToInventory(participants.get(0), 263, CoreConfiguration.coalAMT);

		inventmanage.addToInventory(participants.get(1), 262, 64);
		inventmanage.addToInventory(participants.get(1), 263, CoreConfiguration.coalAMT);
		
		inventmanage.addToInventory(participants.get(0), pref.swordType.get(participants.get(0).getName()), 1);
		inventmanage.addToInventory(participants.get(1), pref.swordType.get(participants.get(0).getName()), 1);

		updateSigns();

	}
	
	@Override
	public void updateSigns(){
		Player p1 = participants.get(0), p2 = participants.get(1);
		s1.setLine(0, ChatColor.DARK_GREEN + "YOU : " + score.get(p1));
		s1.setLine(1, ChatColor.RED + "THEM : " + score.get(p2));
		s2.setLine(0, ChatColor.DARK_GREEN + "YOU : " + score.get(p2));
		s2.setLine(1, ChatColor.RED + "THEM : " + score.get(p1));
		s1.update();
		s2.update();
	}
	
	private int gamePoolerID;

	@Override
	public void initiateScheduler() {
		respawn();
		gamePoolerID = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	
			public void run() {
				tickerTask(gamePoolerID);
			}

		}, 20L, 20L);
	}
	
	

}
