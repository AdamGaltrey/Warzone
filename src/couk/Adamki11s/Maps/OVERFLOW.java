package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class OVERFLOW extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 8.15, 61, 67.5, (float)0.9, (float)9.14));
		loc.add(new Location(Maps.Warzone_World, 8.56, 61, 81.7, (float)178.6, (float)14.99));
		return loc;
	}

	@Override
	public String getName() {
		return "Overflow";
	}

}
