package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class CONTAINMENT extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 156.2, 65, -164.8, (float)-269.4, (float)-1.35));
		loc.add(new Location(Maps.Warzone_World, 104.4, 71, -119.1, (float) 156.2, (float)-0.6));
		return loc;
	}

	@Override
	public String getName() {
		return "Containment";
	}

	
}
