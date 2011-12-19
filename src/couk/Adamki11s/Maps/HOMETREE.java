package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class HOMETREE extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -149.2, 69, 488.5, (float)92.9, (float)-4.47));
		loc.add(new Location(Maps.Warzone_World, -186.3, 68.6, 461.5, (float)269, (float)5.2));
		return loc;
	}

	@Override
	public String getName() {
		return "Hometree";
	}

	
}
