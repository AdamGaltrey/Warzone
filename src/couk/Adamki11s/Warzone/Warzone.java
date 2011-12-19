package couk.Adamki11s.Warzone;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.martin.bukkit.npclib.NPCManager;
import couk.Adamki11s.Commands.WarzoneCommands;
import couk.Adamki11s.Database.Initialise;
import couk.Adamki11s.Database.InventoryData;
import couk.Adamki11s.Database.LanguageConfiguration;
import couk.Adamki11s.Database.MapDataLoader;
import couk.Adamki11s.Database.PermissionsCore;
import couk.Adamki11s.Database.PoolDataLoader;
import couk.Adamki11s.Database.QuitterHandler;
import couk.Adamki11s.Database.Ranks;
import couk.Adamki11s.Extras.Colour.ExtrasColour;
import couk.Adamki11s.Games.Solo.ABYSS_GD;
import couk.Adamki11s.Games.Solo.AFTERMATH_GD;
import couk.Adamki11s.Games.Solo.ASCENSION_GD;
import couk.Adamki11s.Games.Solo.AURORA_GD;
import couk.Adamki11s.Games.Solo.BLIND_GD;
import couk.Adamki11s.Games.Solo.BLIZZARD_GD;
import couk.Adamki11s.Games.Solo.BURROW_GD;
import couk.Adamki11s.Games.Solo.CASTLE_GD;
import couk.Adamki11s.Games.Solo.CONTAINMENT_GD;
import couk.Adamki11s.Games.Solo.CRYPT_GD;
import couk.Adamki11s.Games.Solo.DOME_GD;
import couk.Adamki11s.Games.Solo.DUNGEON_GD;
import couk.Adamki11s.Games.Solo.Gamedata;
import couk.Adamki11s.Games.Solo.HOMETREE_GD;
import couk.Adamki11s.Games.Solo.JUNGLE_GD;
import couk.Adamki11s.Games.Solo.LAPUTA_GD;
import couk.Adamki11s.Games.Solo.NUKETOWN_GD;
import couk.Adamki11s.Games.Solo.OVERFLOW_GD;
import couk.Adamki11s.Games.Solo.PLAINES_GD;
import couk.Adamki11s.Games.Solo.TOMB_GD;
import couk.Adamki11s.Languages.LangInterface;
import couk.Adamki11s.Lobby.ArenaConfig;
import couk.Adamki11s.Maps.ABYSS;
import couk.Adamki11s.Maps.AFTERMATH;
import couk.Adamki11s.Maps.ASCENSION;
import couk.Adamki11s.Maps.AURORA;
import couk.Adamki11s.Maps.BLIND;
import couk.Adamki11s.Maps.BLIZZARD;
import couk.Adamki11s.Maps.BURROW;
import couk.Adamki11s.Maps.CASTLE;
import couk.Adamki11s.Maps.CONTAINMENT;
import couk.Adamki11s.Maps.CRYPT;
import couk.Adamki11s.Maps.DOME;
import couk.Adamki11s.Maps.DUNGEON;
import couk.Adamki11s.Maps.HOMETREE;
import couk.Adamki11s.Maps.JUNGLE;
import couk.Adamki11s.Maps.LAPUTA;
import couk.Adamki11s.Maps.Map;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.Maps.NUKETOWN;
import couk.Adamki11s.Maps.OVERFLOW;
import couk.Adamki11s.Maps.PLAINES;
import couk.Adamki11s.Maps.TOMB;
import couk.Adamki11s.NPC.NPC_Control;
import couk.Adamki11s.NPC.NPC_Handler;
import couk.Adamki11s.NPC.NPC_Messages;
import couk.Adamki11s.SpoutInterface.SpoutCraftListener;
import couk.Adamki11s.SpoutInterface.SpoutData;
import couk.Adamki11s.SpoutInterface.SpoutStartup;

public class Warzone extends JavaPlugin {
	
	public static QuitterHandler quitterHandle = new QuitterHandler();
	public static NPC_Handler npc_handle;
	public static InventoryData inventData = new InventoryData();
	public static MapDataLoader mdl = new MapDataLoader();
	public static PoolDataLoader pdl = new PoolDataLoader();
	public static NPC_Messages npcMessages = new NPC_Messages();
	
	public static Server server;
	public static Plugin plugin;
	public static JavaPlugin jp;
	public static String prefix = "[Warzone]",
	                     version;
	public static Logger log = Logger.getLogger("Minecraft");
	
	public static HashMap<MapName, Map> mapList = new HashMap<MapName, Map>();
	public static HashMap<MapData, Gamedata> mapData = new HashMap<MapData, Gamedata>();
	
	public static NPCManager npcManage;
	public static NPC_Control npc;
	
	public static ExtrasColour ec = new ExtrasColour();
	
	public static boolean doNPCSpawn = false;

	@Override
	public void onDisable() {
		server.getScheduler().cancelTasks(plugin);
		if(doNPCSpawn){
			npc_handle.despawnNPCS();
		}
		if(!Initialise.mysqlEnabled){
			try{
				Initialise.core.close();
			} catch (Exception ex){}
		} else {
			try{
				Initialise.sqlCore.close();
			} catch (Exception ex){}
		}
		log.info(prefix + " Warzone, version " + version + " disabled successfully!");  
	}
	
	Maps mapsClass = new Maps();
	
	Ranks rnks = new Ranks();
	
	PermissionsCore pc = new PermissionsCore();
	
	public static LangInterface li;
	
	private LanguageConfiguration langConfig = new LanguageConfiguration();
	
	SpoutData spoutData = new SpoutData();
	SpoutStartup spoutStartup;

	@Override
	public void onEnable() {
		version = this.getDescription().getVersion();
		plugin = this;
		jp = this;
		server = getServer();
		PluginManager pm = server.getPluginManager();
		pc.setupPermissions();
		loadMaps();
		new Initialise().init();
		mapsClass.initi();
		langConfig.setup();
		li = new LangInterface(langConfig.loadLang());
		loadData();
		new ArenaConfig().createAC();
		rnks.initialiseRanks();
		mdl.loadMapData();
		pdl.loadPoolingData();
		getCommand("warzone").setExecutor(new WarzoneCommands());
		spoutStartup = new SpoutStartup(pm, log);
		if(Maps.worldFound){
			log.info(li.getObj("[Warzone] By Adamki11s of the MineDev team."));
			log.info(prefix + " Warzone," + li.getObj("version") + " " + version + " " + li.getObj("enabled successfully") + "!");
		}
		
		npcManage = new NPCManager(this);
		npc = new NPC_Control(this, npcManage);
		npc_handle = new NPC_Handler(npcManage, npc);
		npc_handle.spawnDefaultNPCS();
		
		if(doNPCSpawn){	
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Warzone.plugin, new Runnable() {
	
	            public void run() {
	        		npc_handle.enableNPCAIController();
	            }
	        }, 100L);
		
		}
		
		pm.registerEvent(Type.CREATURE_SPAWN, new WarzoneCreatureSpawnEvent(), Event.Priority.Highest, this);
		pm.registerEvent(Type.ENTITY_DAMAGE, new WarzoneEntityListener(), Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_JOIN, new WarzonePlayerListener(), Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_INTERACT, new WarzonePlayerListener(), Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_QUIT, new WarzonePlayerListener(), Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_DROP_ITEM, new WarzonePlayerListener(), Priority.Normal, this);
		pm.registerEvent(Type.PLAYER_TOGGLE_SNEAK, new WarzonePlayerListener(), Priority.Highest, this);
		pm.registerEvent(Type.PLAYER_PORTAL, new WarzonePlayerListener(), Priority.Highest, this);
		pm.registerEvent(Type.BLOCK_BREAK, new WarzoneBlockListener(), Priority.Highest, this);
		pm.registerEvent(Type.BLOCK_PLACE, new WarzoneBlockListener(), Priority.Highest, this);
		pm.registerEvent(Type.BLOCK_FORM, new WarzoneBlockListener(), Priority.Highest, this);
		pm.registerEvent(Type.LEAVES_DECAY, new WarzoneBlockListener(), Priority.Highest, this);
		pm.registerEvent(Type.PLAYER_INTERACT_ENTITY, new WarzonePlayerListener(), Priority.Highest, this);
		
		if(spoutData.isSpoutEnabledGlobally()){
			pm.registerEvent(Type.CUSTOM_EVENT, new SpoutCraftListener(), Priority.Highest, this);
		}
		
	}
	
	public void loadMaps() {
		mapList.put(MapName.ASCENSION, new ASCENSION());
		mapList.put(MapName.CASTLE, new CASTLE());
		mapList.put(MapName.DUNGEON, new DUNGEON());
		mapList.put(MapName.OVERFLOW, new OVERFLOW());
		mapList.put(MapName.PLAINES, new PLAINES());
		mapList.put(MapName.TOMB, new TOMB());
		mapList.put(MapName.BLIZZARD, new BLIZZARD());
		mapList.put(MapName.JUNGLE, new JUNGLE());
		mapList.put(MapName.BLIND, new BLIND());
		mapList.put(MapName.CONTAINMENT, new CONTAINMENT());
		mapList.put(MapName.AFTERMATH, new AFTERMATH());
		mapList.put(MapName.CRYPT, new CRYPT());
		mapList.put(MapName.HOMETREE, new HOMETREE());
		mapList.put(MapName.AURORA, new AURORA());
		mapList.put(MapName.ABYSS, new ABYSS());
		mapList.put(MapName.BURROW, new BURROW());
		mapList.put(MapName.LAPUTA, new LAPUTA());
		mapList.put(MapName.DOME, new DOME());
		mapList.put(MapName.NUKETOWN, new NUKETOWN());
	}
	
	public void loadData(){
		mapData.put(MapData.ASCENSION, new ASCENSION_GD());
		mapData.put(MapData.CASTLE, new CASTLE_GD());
		mapData.put(MapData.DUNGEON, new DUNGEON_GD());
		mapData.put(MapData.OVERFLOW, new OVERFLOW_GD());
		mapData.put(MapData.PLAINES, new PLAINES_GD());
		mapData.put(MapData.TOMB, new TOMB_GD());
		mapData.put(MapData.BLIZZARD, new BLIZZARD_GD());
		mapData.put(MapData.JUNGLE, new JUNGLE_GD());
		mapData.put(MapData.BLIND, new BLIND_GD());
		mapData.put(MapData.CONTAINMENT, new CONTAINMENT_GD());
		mapData.put(MapData.AFTERMATH, new AFTERMATH_GD());
		mapData.put(MapData.CRYPT, new CRYPT_GD());
		mapData.put(MapData.HOMETREE, new HOMETREE_GD());
		mapData.put(MapData.AURORA, new AURORA_GD());
		mapData.put(MapData.ABYSS, new ABYSS_GD());
		mapData.put(MapData.BURROW, new BURROW_GD());
		mapData.put(MapData.LAPUTA, new LAPUTA_GD());
		mapData.put(MapData.DOME, new DOME_GD());
		mapData.put(MapData.NUKETOWN, new NUKETOWN_GD());
	}
	
	public static enum GameType{
		RANKED,
		SOCIAL;
		
		@Override
		public String toString(){
			char first = super.toString().charAt(0);
			String rest = super.toString().substring(1, super.toString().length()).toLowerCase();
			return first + rest;
		}
	}
	
	public static enum MapData {
		ASCENSION,
		CASTLE,
		DUNGEON,
		OVERFLOW,
		PLAINES,
		TOMB,
		JUNGLE,
		BLIZZARD,
		BLIND,
		CONTAINMENT,
		AFTERMATH,
		CRYPT,
		HOMETREE,
		AURORA,
		ABYSS,
		BURROW,
		LAPUTA,
		DOME,
		NUKETOWN;
		
		@Override
		public String toString() {
			String result = super.toString();
			return result.toUpperCase();
		}
	}
	
	public static enum MapName {
		ASCENSION,
		CASTLE,
		DUNGEON,
		OVERFLOW,
		PLAINES,
		TOMB,
		JUNGLE,
		BLIZZARD,
		BLIND,
		CONTAINMENT,
		AFTERMATH,
		CRYPT,
		HOMETREE,
		AURORA,
		ABYSS,
		BURROW,
		LAPUTA,
		DOME,
		NUKETOWN;
		
		@Override
		public String toString() {
			String result = super.toString();
			return result.toUpperCase();
		}
	}
	
}
