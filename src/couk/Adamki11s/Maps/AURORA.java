package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class AURORA extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -314.3, 121, 233.3, (float)-87.8, (float)4.6));
		loc.add(new Location(Maps.Warzone_World, -264.7, 121, 288.1, (float)-177.5, (float)-0.45));
		return loc;
	}

	@Override
	public String getName() {
		return "Aurora";
	}

	
}
