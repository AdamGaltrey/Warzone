package couk.Adamki11s.NPC;

import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.martin.bukkit.npclib.NPCEntity;
import org.martin.bukkit.npclib.NPCManager;

import couk.Adamki11s.Warzone.Warzone;

public class NPC_Control {
	
	public Warzone main;
	public HashMap<String, NPCEntity> npcs = new HashMap<String, NPCEntity>();
	public NPCManager NpcManager;	
	
	public NPC_Control(Warzone main, NPCManager NpcManager){
		this.main = main;
		this.NpcManager = NpcManager;
	}
	
	public void setItemInHand(String reference, Material m) {
		npcs.get(reference).setItemInHand(m);
	}
	
	public void setPositionRotation(String reference, double x, double y, double z, float yaw, float pitch) {
		npcs.get(reference).setPositionRotation(x, y, z, yaw, pitch);
	}
	
	public void setPositionRotation(String reference, Location l) {
		npcs.get(reference).setPositionRotation(l.getBlockX(), l.getBlockY(), l.getBlockZ(), l.getYaw(), l.getPitch());
	}
	
	public void die(String reference) {
		npcs.get(reference).die(npcs.get(reference));
	}
	
	 public void actAsHurt(String reference) {
		 npcs.get(reference).actAsHurt();
	 }

	 public void animateArmSwing(String reference) {
		npcs.get(reference).animateArmSwing();
	 }
	 
	 public HashMap<String, NPCEntity> getMap(){
		 return npcs;
	 }
	
	public void spawn(String reference, Location loc){
		if(!npcs.containsKey(reference)){
			npcs.put(reference, NpcManager.spawnNPC(reference, loc));
		} else {
			NpcManager.spawnNPC(reference, loc);
		}
	}
	
	public void despawn(String reference){
		if (!check(reference)) return;
		NpcManager.despawn(reference);
		npcs.remove(reference);
	}
	public boolean check(String reference){
		if(npcs.get(reference) != null){
			return true;
		}else{
			return false;
		}
	}
	
	////////////////////////
	///Additional Methods///
	////////////////////////
	
	public void move(String reference, double x, double y, double z, World w) {
		npcs.get(reference).pathFindTo(new Location(w, x, y, z), 999999999);
	}
	
	public void move(String reference, Location loc){
		npcs.get(reference).pathFindTo(loc, 999999999);
	}
	
	public boolean isSneaking(String reference){
		return npcs.get(reference).isSneaking();
	}
	
	public void setSneaking(String reference, boolean sneak){
		npcs.get(reference).setSneak(sneak);
	}
	
	public boolean isSleeping(String reference){
		return npcs.get(reference).isSleeping();
	}
	
	public boolean onGround(String reference){
		return npcs.get(reference).onGround;
	}
	
	public int getHealth(String reference){
		return npcs.get(reference).health;
	}
	
	public void mount(String reference,String reference2){
		npcs.get(reference).mount(npcs.get(reference2));
	}
	
	public boolean isMounted(String reference){
		if(npcs.get(reference).getBukkitEntity().getPassenger() == null){
			return false;
		} else {
			return true;
		}
	}
	
	public void unmount(String reference, Entity mounted){
		mounted.setPassenger(null);
	}
	
	public void damage(String reference, int damage){
		Player p = (Player) npcs.get(reference).getBukkitEntity();
		int health = p.getHealth();
		if(damage > health){
			npcs.get(reference).actAsHurt();
			despawn(reference);
		} else {
			p.damage(damage);
		}
	}	
	
	public World getWorld(String reference){
		return npcs.get(reference).getBukkitEntity().getLocation().getWorld();
	}
	
	public Location getLocation(String reference){
		return npcs.get(reference).getBukkitEntity().getLocation();
	}
	
	public void setLocation(Location l, String reference){
		npcs.get(reference).getBukkitEntity().teleport(l);
	}
	
	public Entity getBukkitEntity(String reference){
		return npcs.get(reference).getBukkitEntity();
	}
	
	

}
