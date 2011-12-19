package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class BLIZZARD extends Map{

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
		loc.add(new Location(Maps.Warzone_World, -155, 69, 111.5, (float)-268.16, (float)1.5));
		loc.add(new Location(Maps.Warzone_World, -191.4, 69, 115.5, (float)-89.3, (float)-12.75));
		return loc;
	}

	@Override
	public String getName() {
		return "Blizzard";
	}
	
}
