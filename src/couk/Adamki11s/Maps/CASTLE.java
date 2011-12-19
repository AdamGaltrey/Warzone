package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class CASTLE extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -22.0, 65, 125.0, (float)-101.5, (float)-1.2));
		loc.add(new Location(Maps.Warzone_World, -6.8, 65, 106.5, (float)62.9, (float)-3.16));
		return loc;
	}

	@Override
	public String getName() {
		return "Castle";
	}

}
