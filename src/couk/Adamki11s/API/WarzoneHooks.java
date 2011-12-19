package couk.Adamki11s.API;

import java.util.Map;
import org.bukkit.entity.Player;
import couk.Adamki11s.Database.Statistics;
import couk.Adamki11s.Games.Solo.Gamedata;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.Warzone.Warzone;
import couk.Adamki11s.Warzone.Warzone.MapName;

public class WarzoneHooks extends WarzoneHandler {

	@Override
	public boolean isInWarzoneWorld(Player p) {
		if(p.getWorld() == Maps.Warzone_World){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRankTitle(Player p) {
		return Statistics.levelTitles.get(Statistics.playerLevel.get(p.getName()));
	}

	@Override
	public boolean isInGame(Player p) {	
		for(Map.Entry<MapName, couk.Adamki11s.Maps.Map> maplist : Warzone.mapList.entrySet()){
			if(maplist.getValue().isOccupied()){
				Gamedata gd = Warzone.mapData.get(maplist.getValue());
				if(gd.getParticipants().contains(p)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public float getScore(Player p) {
		if(Statistics.gamesPlayed.get(p) > 0){
			return Statistics.playerScore.get(p.getName());
		} else {
			return (float)0;
		}
	}

}
