package couk.Adamki11s.NPC;

import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.martin.bukkit.npclib.NPCManager;
import couk.Adamki11s.Extras.Random.ExtrasRandom;
import couk.Adamki11s.Maps.Maps;
import couk.Adamki11s.Warzone.Warzone;

public class NPC_Handler {

	public static NPCManager npcManage;
	public static NPC_Control npc;
	public static int ai_ID, loader_ID, Q_1, Q_2, Q_3, Q_4, Q_5, R_A, R_M, R_D_M;

	private ArrayList<AINPC> npcRef = new ArrayList<AINPC>();

	Location b_c_1 = new Location(Maps.Warzone_World, -94.8, 76, 214.5),
	b_c_2 = new Location(Maps.Warzone_World, -106.5, 76, 230.1);
	
	ExtrasRandom exr = new ExtrasRandom();

	public NPC_Handler(NPCManager npcManage2, NPC_Control npc2) {
		npcManage = npcManage2;
		npc = npc2;
	}
	
	public void enableNPCAIController(){
		loader_ID = Warzone.server.getScheduler().scheduleSyncDelayedTask(Warzone.plugin, new Runnable() {	

			public void run() {

				if(npcRef.isEmpty()){
					initialiseNPCMap();
				}
					spawnAllNPCS();			

			}

		}, 1L);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initiate_Q_1();
		initiate_Q_2();
		initiate_Q_3();
		initiate_Q_4();
		initiate_Q_5();
	}

	public void initiate_Q_1(){
		Q_1 = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	

			public void run() {

				Q_1();

			}

		},41L, 42L);
	}
	
	public void initiate_Q_2(){
		Q_2 = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	

			public void run() {

				Q_2();

			}

		}, 41L, 50L);
	}
	
	public void initiate_Q_3(){
		Q_3 = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	

			public void run() {

				Q_3();

			}

		}, 41L, 35L);
	}
	
	public void initiate_Q_4(){
		Q_4 = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	

			public void run() {

				Q_4();

			}

		}, 41L, 80L);
	}
	
	public void initiate_Q_5(){
		Q_5 = Warzone.server.getScheduler().scheduleSyncRepeatingTask(Warzone.plugin, new Runnable() {	

			public void run() {

				Q_5();

			}

		}, 41L, 60L);
	}

	private void initialiseNPCMap(){
		npcRef.add(AINPC.Adamki11s);
		npcRef.add(AINPC.iPhysX);
		npcRef.add(AINPC.alta189);
		npcRef.add(AINPC.cronikkk);
		npcRef.add(AINPC.Xephos);
		npcRef.add(AINPC.jamescosten);
		npcRef.add(AINPC.Notch);
		npcRef.add(AINPC.EvilSeph);
		npcRef.add(AINPC.Dinnerbone);
		npcRef.add(AINPC.Israphel);
		npcRef.add(AINPC.RightLegRed);
		npcRef.add(AINPC.Afforess);
		npcRef.add(AINPC.Coestar);
		npcRef.add(AINPC.Honeydew);
	}
	
	private Location Adamki11sSpawn = new Location(Maps.Warzone_World, -100.5, 78, 210.7, (float)-181, (float)5.85),
	                 iPhysXSpawn = new Location(Maps.Warzone_World, -95.3, 78, 210, (float)179.45, (float)4.5),
	                 alta189Spawn = new Location(Maps.Warzone_World, -105.5, 78, 210, (float)179.45, (float)4.5);
	
	public void spawnAllNPCS(){
		for(AINPC ref : npcRef){
			String r = ref.toString();
			Location l = getRandomSpawn();
			spawnNPC(r, l);
		}
		npc.setItemInHand(AINPC.Afforess.toString(), Material.BOOK);
		npc.setItemInHand(AINPC.alta189.toString(), Material.BED);
		npc.setItemInHand(AINPC.cronikkk.toString(), Material.EGG);
		npc.setItemInHand(AINPC.Dinnerbone.toString(), Material.BEDROCK);
		npc.setItemInHand(AINPC.EvilSeph.toString(), Material.GOLD_BLOCK);
		npc.setItemInHand(AINPC.Coestar.toString(), Material.BOAT);
		npc.setItemInHand(AINPC.jamescosten.toString(), Material.CACTUS);
		npc.setItemInHand(AINPC.iPhysX.toString(), Material.BURNING_FURNACE);
		npc.setItemInHand(AINPC.Honeydew.toString(), Material.GRILLED_PORK);
		npc.setItemInHand(AINPC.Israphel.toString(), Material.GREEN_RECORD);
		npc.setItemInHand(AINPC.Xephos.toString(), Material.LAPIS_BLOCK);
		npc.setItemInHand(AINPC.Notch.toString(), Material.GOLDEN_APPLE);
		npc.setItemInHand(AINPC.RightLegRed.toString(), Material.PUMPKIN);
	}
	
	public void spawnDefaultNPCS(){
		/*for(AINPC ref : npcRef){
			String r = ref.toString();
			Location l = getRandomSpawn();
			spawnNPC(r, l);
		}*/
		spawnNPC("Adamki11s", Adamki11sSpawn);
	     spawnNPC("iPhysX", iPhysXSpawn);
	     spawnNPC("alta189", alta189Spawn);
		npc.setItemInHand(AINPC.Adamki11s.toString(), Material.DIAMOND_SWORD);
		npc.setItemInHand(AINPC.alta189.toString(), Material.GOLD_SWORD);
		npc.setItemInHand(AINPC.iPhysX.toString(), Material.GOLD_SWORD);
		/*npc.setItemInHand(AINPC.Afforess.toString(), Material.BOOK);
		npc.setItemInHand(AINPC.alta189.toString(), Material.BED);
		npc.setItemInHand(AINPC.cronikkk.toString(), Material.EGG);
		npc.setItemInHand(AINPC.Dinnerbone.toString(), Material.BEDROCK);
		npc.setItemInHand(AINPC.EvilSeph.toString(), Material.GOLD_BLOCK);
		npc.setItemInHand(AINPC.Coestar.toString(), Material.BOAT);
		npc.setItemInHand(AINPC.jamescosten.toString(), Material.CACTUS);
		npc.setItemInHand(AINPC.iPhysX.toString(), Material.BURNING_FURNACE);
		npc.setItemInHand(AINPC.Honeydew.toString(), Material.GRILLED_PORK);
		npc.setItemInHand(AINPC.Israphel.toString(), Material.GREEN_RECORD);
		npc.setItemInHand(AINPC.Xephos.toString(), Material.LAPIS_BLOCK);
		npc.setItemInHand(AINPC.Notch.toString(), Material.GOLDEN_APPLE);
		npc.setItemInHand(AINPC.RightLegRed.toString(), Material.PUMPKIN);*/	
	}
	
	public void despawnNPCS(){
		/*for(AINPC ref : npcRef){
			npc.despawn(ref.toString());
		}*/
		npc.despawn("Adamki11s");
		npc.despawn("iPhysX");
		npc.despawn("alta189");
		System.out.println("[Warzone] NPC'S despawned successfully.");
	}
	
	private void Q_1(){
		AINPC xq1 = AINPC.Adamki11s, xq2 = AINPC.Afforess, xq3 = AINPC.alta189;
		npc.move(xq1.toString(), getRandomSpawn());
		npc.move(xq2.toString(), getRandomSpawn());
		npc.move(xq3.toString(), getRandomSpawn());
	}
	
	private void Q_2(){
		AINPC xq1 = AINPC.cronikkk, xq2 = AINPC.Dinnerbone, xq3 = AINPC.EvilSeph;
		npc.move(xq1.toString(), getRandomSpawn());
		npc.move(xq2.toString(), getRandomSpawn());
		npc.move(xq3.toString(), getRandomSpawn());
	}
	
	private void Q_3(){
		AINPC xq1 = AINPC.Coestar, xq2 = AINPC.iPhysX, xq3 = AINPC.jamescosten;
		npc.move(xq1.toString(), getRandomSpawn());
		npc.move(xq2.toString(), getRandomSpawn());
		npc.move(xq3.toString(), getRandomSpawn());
	}
	
	private void Q_4(){
		AINPC xq1 = AINPC.Honeydew, xq2 = AINPC.Israphel, xq3 = AINPC.Xephos;
		npc.move(xq1.toString(), getRandomSpawn());
		npc.move(xq2.toString(), getRandomSpawn());
		npc.move(xq3.toString(), getRandomSpawn());
	}
	
	private void Q_5(){
		AINPC xq1 = AINPC.Notch, xq3 = AINPC.RightLegRed;
		npc.move(xq1.toString(), getRandomSpawn());
		npc.move(xq3.toString(), getRandomSpawn());
	}
	
	private Location getRandomSpawn(){
		World w = Maps.Warzone_World;//92 - 108, 212 - 232
		double x = 92 + exr.getRandomInt(16, 0),
		y = 74,
		z = 212 + exr.getRandomInt(20, 0);
		x *= -1;
		float _y = 0 + exr.getRandomInt(350, 5),
		_p = -12 + exr.getRandomInt(42, 0);
		
		return new Location(w, x, y, z, _y, _p);	
	}

	public void spawnNPC(String name, Location loc){
		npc.spawn(name, loc);
	}

}
