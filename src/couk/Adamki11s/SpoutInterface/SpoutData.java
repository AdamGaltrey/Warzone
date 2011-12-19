package couk.Adamki11s.SpoutInterface;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;

public class SpoutData {
	
	public static boolean global_spoutEnabled;
	
	public static HashMap<Player, Boolean> spoutEnabled = new HashMap<Player, Boolean>();
	
	public boolean isSpoutEnabledGlobally(){
		if(global_spoutEnabled){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean doesPlayerHaveSpout(Player p){
		return spoutEnabled.get(p);
	}

}
