package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class TOMB extends Map {
	
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
		loc.add(new Location(Maps.Warzone_World, -205.49, 72, -22.1, (float)-179, (float)6.75));
		loc.add(new Location(Maps.Warzone_World, -236.4, 72, -33.6, (float)-0.08, (float)6.3));
		return loc;
	}

	@Override
	public String getName() {
		return "Tomb";
	}

}
