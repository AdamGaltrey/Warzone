package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class JUNGLE extends Map {
	
	private boolean isOccupied;

	@Override
	public boolean isOccupied() {
		return isOccupied;
	}

	@Override
	public void setOccupiedState(boolean occupationState) {
		isOccupied = occupationState;
	}

	@Override
	public ArrayList<Location> getSpawnPoints() {
		ArrayList<Location> loc = new ArrayList<Location>();
		loc.add(new Location(Maps.Warzone_World, -85.8, 73, 105, (float)88.5, (float)9));
		loc.add(new Location(Maps.Warzone_World, -113, 73, 141, (float)270, (float)9.7));
		return loc;
	}

	@Override
	public String getName() {
		return "Jungle";
	}

}
