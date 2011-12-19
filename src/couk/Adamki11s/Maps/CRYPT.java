package couk.Adamki11s.Maps;

import java.util.ArrayList;

import org.bukkit.Location;

public class CRYPT extends Map {

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
		loc.add(new Location(Maps.Warzone_World, -109.3, 74, 402.2, (float)317.1, (float)8.27));
		loc.add(new Location(Maps.Warzone_World, -79.6, 74, 444.5, (float)136.8, (float)-5.85));
		return loc;
	}

	@Override
	public String getName() {
		return "Crypt";
	}

	
}
