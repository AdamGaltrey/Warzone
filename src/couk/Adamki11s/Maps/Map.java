package couk.Adamki11s.Maps;

import java.util.ArrayList;
import org.bukkit.Location;

public abstract class Map {
	
	public abstract boolean isOccupied();
	
	public abstract void setOccupiedState(boolean occupationState);
	
	public abstract ArrayList<Location> getSpawnPoints();
	
	public abstract String getName();
}
