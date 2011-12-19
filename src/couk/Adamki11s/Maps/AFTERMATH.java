package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class AFTERMATH extends Map {

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
		loc.add(new Location(Maps.Warzone_World, 196, 53, -55, (float)-90.4, (float)2.9));
		loc.add(new Location(Maps.Warzone_World, 242, 53, -52, (float)-270.2, (float)2.09));
		return loc;
	}

	@Override
	public String getName() {
		return "Aftermath";
	}

	
}
