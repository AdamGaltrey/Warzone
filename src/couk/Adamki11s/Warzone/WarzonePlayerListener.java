package couk.Adamki11s.Warzone;

import java.net.MalformedURLException;
import java.util.Map.Entry;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.martin.bukkit.npclib.NPCEntity;
import couk.Adamki11s.Database.Initialise;
import couk.Adamki11s.Database.LobbyPlaceHolder;
import couk.Adamki11s.Database.Preferences;
import couk.Adamki11s.Database.Statistics;
import couk.Adamki11s.Extras.Inventory.ExtrasInventory;
import couk.Adamki11s.Extras.Player.ExtrasPlayer;
import couk.Adamki11s.Games.Solo.Gamedata;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.NPC.AINPC;
import couk.Adamki11s.SpoutInterface.SpoutData;
import couk.Adamki11s.Warzone.Warzone.MapData;

public class WarzonePlayerListener extends PlayerListener {
	
	LobbyPlaceHolder lph = new LobbyPlaceHolder();

	public void onPlayerJoin(PlayerJoinEvent evt){
		SpoutData.spoutEnabled.put(evt.getPlayer(), false);
		Maps.Warzone_World.setPVP(true);
		if(lph.checkLobby(evt.getPlayer())){
			evt.getPlayer().teleport(lph.getLobbyDump(evt.getPlayer()));
			lph.removeLobbyDumpFile(evt.getPlayer());
			evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You quit unexpectedly!"));
			evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("Returned to previous location."));
		}
		if(!pref.doesPlayerHavePreferenceFile(evt.getPlayer().getName())){
			pref.createPreferenceFile(evt.getPlayer().getName());
		}
		pref.loadPreferences(evt.getPlayer().getName());
		if(Warzone.inventData.isInNeedOfInventoryLoading(evt.getPlayer())){
			evt.getPlayer().getInventory().setContents(Warzone.inventData.loadInventory(evt.getPlayer()));
			Warzone.inventData.checkFile(evt.getPlayer());
			evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + ChatColor.GREEN + Warzone.li.getObj("Inventory was restored successfully."));
		}
		if(!Statistics.databaseHoldings.contains(evt.getPlayer().getName())){
			if(!Initialise.mysqlEnabled){
				Initialise.core.insertQuery("INSERT INTO statistics (player, wins, draws, losses, shotsfired, shotshit, shotsmissed, kills, deaths, playtime, gp)" +
						" values ('" + evt.getPlayer().getName() + "', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0');");
				Statistics.databaseHoldings.add(evt.getPlayer().getName());
			} else {
				try {
					Initialise.sqlCore.insertQuery("INSERT INTO statistics (player, wins, draws, losses, shotsfired, shotshit, shotsmissed, kills, deaths, playtime, gp)" +
							" values ('" + evt.getPlayer().getName() + "', '1', '1', '1', '1', '1', '1', '1', '1', '0', '0');");
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
				Statistics.databaseHoldings.add(evt.getPlayer().getName());
			}
		}
		Initialise.pushStatistics(evt.getPlayer());
		if(Warzone.quitterHandle.doesExist(evt.getPlayer())){
			evt.getPlayer().teleport(Warzone.quitterHandle.getQuitterLocation(evt.getPlayer()));
			evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You quit during a game! Returned to initial location."));
			Warzone.quitterHandle.removeQuitter(evt.getPlayer());
		}
	}
	
	ExtrasInventory invManage = new ExtrasInventory();
	ExtrasPlayer exP = new ExtrasPlayer();
	Preferences pref = new Preferences();

	public void onPlayerInteract(PlayerInteractEvent evt){
		Player player = evt.getPlayer();
		if (((evt.getAction() == Action.RIGHT_CLICK_AIR)) && 
				(player.getItemInHand().getTypeId() == 261) && (player.getInventory().contains(262))){
			for(Entry<MapData, Gamedata> maps : Warzone.mapData.entrySet()){
				if(maps.getValue().getParticipants().contains(player)){
					Gamedata gd = maps.getValue();
					gd.shotFired(player);
				}
			}
		} else if((player.getLocation().getWorld() == Maps.Warzone_World) && ((evt.getAction() == Action.LEFT_CLICK_AIR) || evt.getAction() == Action.LEFT_CLICK_BLOCK) &&
		(player.getItemInHand().getTypeId() == 261) && player.getInventory().contains(263)){		
			for(Entry<MapData, Gamedata> maps : Warzone.mapData.entrySet()){
				if(maps.getValue().getParticipants().contains(player)){
					Location loc = player.getLocation();
					if(invManage.getAmountOf(player, 263) > 1){
						invManage.removeFromInventory(player, 263, 1);
					} else {
						invManage.removeAllFromInventory(player, 263);
					}
					World w = loc.getWorld();
					loc = exP.getLocationLooked(player);
					int repeat = 0;
					while(repeat < 1){
					for(double x = (loc.getX() - 3); x <= (loc.getX() + 3); x++){
						for(double y = (loc.getY() - 3); y <= (loc.getY() + 3); y++){
							for(double z = (loc.getZ() - 3); z <= (loc.getZ() + 3); z++){
								w.playEffect(new Location(w, x, y, z), Effect.SMOKE, 10);
							}
						}
					}
					repeat++;
					}
				}
			}
		}
	}
	
	public void onPlayerToggleSneak(PlayerToggleSneakEvent evt) {
		Player player = evt.getPlayer();
		for(Entry<MapData, Gamedata> maps : Warzone.mapData.entrySet()){
			if(maps.getValue().getParticipants().contains(player)){
				if(evt.isSneaking()){
					evt.getPlayer().setSneaking(true);
		        	evt.setCancelled(true);
				}
			}
		}
     }
	
	public void onPlayerDropItem(PlayerDropItemEvent evt){
		Player player = evt.getPlayer();
		for(Entry<MapData, Gamedata> maps : Warzone.mapData.entrySet()){
			if(maps.getValue().getParticipants().contains(player)){
				evt.setCancelled(true);				
		}
		}
	}
	
	public void onPlayerPortal(PlayerPortalEvent evt){
		if(evt.getPlayer().getWorld() == Maps.Warzone_World){
			evt.setCancelled(true);
		}
	}
	
	public void onPlayerInteractEntity(PlayerInteractEntityEvent evt){
		if(Warzone.npcManage.isNPC(evt.getRightClicked())){
			CraftEntity e = (CraftEntity)evt.getRightClicked();
			NPCEntity npce = (NPCEntity) e.getHandle();
			AINPC ainpc = Warzone.npcMessages.getAINPCFromName(npce.name);
			String randomMessage = Warzone.npcMessages.getRandomMessage(ainpc);
		    evt.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.YELLOW + npce.name + ChatColor.RED + "] " + ChatColor.WHITE + randomMessage);
		}
	}

}
