package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class LAPUTA extends Map{

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
		loc.add(new Location(Maps.Warzone_World, -217, 95, 761.7, (float)178.4, (float)-2.1));
		loc.add(new Location(Maps.Warzone_World, -216.8, 95, 662.2, (float)2.76, (float)0.02));
		return loc;
	}

	@Override
	public String getName() {
		return "Laputa";
	}

	
}
