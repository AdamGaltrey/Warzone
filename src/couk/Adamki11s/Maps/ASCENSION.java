package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class ASCENSION extends Map {
	
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
		loc.add(new Location(Maps.Warzone_World, 20.3, 75, 116.3, (float)226.2, (float)11.24));
		loc.add(new Location(Maps.Warzone_World, 37.4, 75, 99.6, (float)43.3, (float)12.14));
		return loc;
	}

	@Override
	public String getName() {
		return "Ascension";
	}

}
