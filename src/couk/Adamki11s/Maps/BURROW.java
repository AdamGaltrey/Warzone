package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class BURROW extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 50.5, 117.6, 489.6, (float)1.12, (float)1.04));
		loc.add(new Location(Maps.Warzone_World, 50.6, 125, 531.7, (float)179.6, (float)-4.03));
		return loc;
	}

	@Override
	public String getName() {
		return "Burrow";
	}

	
}
