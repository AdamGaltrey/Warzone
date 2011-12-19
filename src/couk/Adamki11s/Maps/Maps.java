package couk.Adamki11s.Maps;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.World;
import org.bukkit.World.Environment;

import couk.Adamki11s.Warzone.Warzone;

public class Maps {
	
	public static World Warzone_World;
	public static boolean worldFound = false;
	
	public void initi(){
		worldFound = false;
		if(new File("WarzoneWorld").exists()){
			Warzone.server.createWorld("WarzoneWorld", Environment.NORMAL);
			Warzone_World = Warzone.server.getWorld("WarzoneWorld");
			worldFound = true;
			System.out.println(Warzone.prefix + " World loaded successfully!");
		} else {
			worldFound = false;
			Logger.getLogger("Warzone").severe("[Warzone] Warzone world not found! Plugin disabled!");
			Warzone.server.getPluginManager().disablePlugin(Warzone.plugin);
		}	
	}
	
	

}
