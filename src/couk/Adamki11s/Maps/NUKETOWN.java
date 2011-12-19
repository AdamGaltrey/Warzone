package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class NUKETOWN extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 167.2, 73, 361.6, (float)-0.7, (float)6.16));
		loc.add(new Location(Maps.Warzone_World, 168.5, 73, 491.8, (float)-179.8, (float)-0.9));
		return loc;
	}

	@Override
	public String getName() {
		return "Nuketown";
	}

	
}
