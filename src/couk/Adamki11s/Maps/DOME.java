package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class DOME extends Map{

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
		loc.add(new Location(Maps.Warzone_World, -384.5, 38, 753.8, (float)-0.21, (float)-4.2));
		loc.add(new Location(Maps.Warzone_World, -384.5, 38, 792.8, (float)181.6, (float)-7.38));
		return loc;
	}

	@Override
	public String getName() {
		return "Dome";
	}

	
}
