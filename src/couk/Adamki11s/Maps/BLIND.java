package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class BLIND extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 72, 68, 15.5, (float)-270, (float)-0.3));
		loc.add(new Location(Maps.Warzone_World, 45.1, 68, 14.4, (float)-90.3, (float)-0.9));
		return loc;
	}

	@Override
	public String getName() {
		return "Blind";
	}

	
}
