package couk.Adamki11s.Warzone;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityListener;

import couk.Adamki11s.Maps.Maps;

public class WarzoneCreatureSpawnEvent extends EntityListener {
	
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if(event.getLocation().getWorld() == Maps.Warzone_World){
			event.setCancelled(true);
		}
	}

}
