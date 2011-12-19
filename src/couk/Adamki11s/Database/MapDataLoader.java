package couk.Adamki11s.Database;

import java.io.File;

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
import couk.Adamki11s.Games.Solo.HOMETREE_GD;
import couk.Adamki11s.Games.Solo.JUNGLE_GD;
import couk.Adamki11s.Games.Solo.LAPUTA_GD;
import couk.Adamki11s.Games.Solo.NUKETOWN_GD;
import couk.Adamki11s.Games.Solo.OVERFLOW_GD;
import couk.Adamki11s.Games.Solo.PLAINES_GD;
import couk.Adamki11s.Games.Solo.TOMB_GD;

public class MapDataLoader {
	
	SettingsHandler mapTimes = new SettingsHandler("ConfigurationFiles/MapData.config", "plugins" + 
			 File.separator +  "Warzone" + File.separator +"Configuration"  + File.separator + "MapData.config");
	
	public void loadMapData(){
		mapTimes.load();
		ASCENSION_GD.gameTime = mapTimes.getPropertyInteger("Ascension");
		BLIZZARD_GD.gameTime = mapTimes.getPropertyInteger("Blizzard");
		CASTLE_GD.gameTime = mapTimes.getPropertyInteger("Castle");
		DUNGEON_GD.gameTime = mapTimes.getPropertyInteger("Dungeon");
		JUNGLE_GD.gameTime = mapTimes.getPropertyInteger("Jungle");
		OVERFLOW_GD.gameTime = mapTimes.getPropertyInteger("Overflow");
		PLAINES_GD.gameTime = mapTimes.getPropertyInteger("Plaines");
		TOMB_GD.gameTime = mapTimes.getPropertyInteger("Tomb");
		BLIND_GD.gameTime = mapTimes.getPropertyInteger("Blind");
		CONTAINMENT_GD.gameTime = mapTimes.getPropertyInteger("Containment");
		AFTERMATH_GD.gameTime = mapTimes.getPropertyInteger("Aftermath");
		CRYPT_GD.gameTime = mapTimes.getPropertyInteger("Crypt");
		HOMETREE_GD.gameTime = mapTimes.getPropertyInteger("Hometree");
		AURORA_GD.gameTime = mapTimes.getPropertyInteger("Aurora");
		ABYSS_GD.gameTime = mapTimes.getPropertyInteger("Abyss");
		BURROW_GD.gameTime = mapTimes.getPropertyInteger("Burrow");
		LAPUTA_GD.gameTime = mapTimes.getPropertyInteger("Laputa");
		DOME_GD.gameTime = mapTimes.getPropertyInteger("Dome");
		NUKETOWN_GD.gameTime = mapTimes.getPropertyInteger("Nuketown");
		System.out.println("[Warzone] Map configuration loaded successfully!");
	}

}
