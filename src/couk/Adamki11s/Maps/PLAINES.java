package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class PLAINES extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -11.7, 71, 171, (float)290.3, (float)5.5));
		loc.add(new Location(Maps.Warzone_World, 23.2, 71, 181.4, (float)109.7, (float)1.67));
		return loc;
	}

	@Override
	public String getName() {
		return "Plaines";
	}

}
