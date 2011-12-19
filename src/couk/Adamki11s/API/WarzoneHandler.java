package couk.Adamki11s.API;

import org.bukkit.entity.Player;

public abstract class WarzoneHandler {
	
	//WarzoneHandler wh = new WarzoneHooks();
	
	public abstract boolean isInWarzoneWorld(Player p);
	
	public abstract String getRankTitle(Player p);
	
	public abstract boolean isInGame(Player p);
	
	public abstract float getScore(Player p);

}
