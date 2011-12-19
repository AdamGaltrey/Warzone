package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class ABYSS extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -156.5, 89, 561.3, (float)-176.45, (float)8.25));
		loc.add(new Location(Maps.Warzone_World, -182.4, 89, 536.2, (float)-357.2, (float)3.6));
		return loc;
	}

	@Override
	public String getName() {
		return "Abyss";
	}

	
}
