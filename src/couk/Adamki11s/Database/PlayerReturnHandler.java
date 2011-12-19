package couk.Adamki11s.Database;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.config.Configuration;

import couk.Adamki11s.Warzone.Warzone;

public class PlayerReturnHandler {
	
	private File mainDir = new File("plugins/Warzone" + File.separator + "Return");
	
	public void addReturn(Player p, Location l){
		try {
			File f = new File(mainDir + File.separator + p.getName() + ".yml");
			f.createNewFile();
			Configuration c = new Configuration(f);
			c.setProperty("World", l.getWorld().getName().toString());
			c.setProperty("X", l.getX());
			c.setProperty("Y", l.getY());
			c.setProperty("Z", l.getZ());
			c.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public Location getReturnLocation(Player p){
		File f = new File(mainDir + File.separator + p.getName() + ".yml");
		Configuration c = new Configuration(f);
		c.load();
		World w = Warzone.server.getWorld(c.getString("World").toString());
		double x = c.getDouble("X", 0), y = c.getDouble("Y", 0), z = c.getDouble("Z", 0);
		return new Location(w, x, y, z);
	}
	
	public void removeReturn(Player p){
		new File(mainDir + File.separator + p.getName() + ".yml").delete();
	}
	
	public boolean doesExist(Player p){
		if(new File(mainDir + File.separator + p.getName() + ".yml").exists()){
			return true;
		} else {
			return false;
		}
	}

}
