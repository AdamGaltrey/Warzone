package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class DUNGEON extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 2, 58, 117.0, (float)-95.8, (float)-1.05));
		loc.add(new Location(Maps.Warzone_World, 16.69, 58, 116.2, (float)88.2, (float)5.39));
		return loc;
	}

	@Override
	public String getName() {
		return "Dungeon";
	}

}
