package couk.Adamki11s.Warzone;

import java.util.Map.Entry;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;
import couk.Adamki11s.Extras.Colour.ExtrasColour;
import couk.Adamki11s.Extras.Regions.ExtrasRegions;
import couk.Adamki11s.Games.Solo.Gamedata;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.Warzone.Warzone.MapData;

public class WarzoneEntityListener extends EntityListener {
	
	ExtrasColour ec = new ExtrasColour();
	ExtrasRegions exr = new ExtrasRegions();
	
	public void onEntityDamage(EntityDamageEvent evt){
		//Damage of 4 == Arrow hit
		//Damage of 5+ must be sword
		boolean needtocancel = true;
		if(!Maps.Warzone_World.getPVP()){
			Maps.Warzone_World.setPVP(true);
		}
		if (evt instanceof EntityDamageByEntityEvent) {
			Entity e = evt.getEntity();
			Entity damaged = ((EntityDamageByEntityEvent)evt).getDamager();
			
			if(e instanceof Player && damaged instanceof Player){
				Player p = (Player)e;
				Player other = (Player)damaged;
				if(p.getName() != other.getName()){
					for(Entry<MapData, Gamedata> maps : Warzone.mapData.entrySet()){
						if(maps.getValue().getParticipants().contains(p) && maps.getValue().getParticipants().contains(damaged)){
								Gamedata gd = maps.getValue();
								EntityDamageByEntityEvent edbee = (EntityDamageByEntityEvent)evt;
								Player damager = (Player) edbee.getDamager();
								Player target = (Player) edbee.getEntity();
								needtocancel = false;
								if(evt.getDamage() >= 5){
									gd.swordStruck(damager, target);
								} else {
									gd.shotHit(damager, target);
								}
								evt.setDamage(1);
						}
					}
				}
			}
		}
		
		if(evt.getEntity().getWorld() == Maps.Warzone_World && needtocancel){
			evt.setCancelled(true);
		}
	}

}
