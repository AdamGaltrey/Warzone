package couk.Adamki11s.Database;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.config.Configuration;

import couk.Adamki11s.Warzone.Warzone;

public class LobbyPlaceHolder {
	
	File root = new File("plugins/Warzone/Lobby");
	
	public boolean checkLobby(Player p){
		String name = p.getName();
		File path = new File(root + File.separator + name + ".lobbydata");
		if(path.exists()){
			return true;
		} else {
			return false;
		}
	}
	
	public void createLobbyFile(Player p, Location l){
		String name = p.getName();
		File path = new File(root + File.separator + name + ".lobbydata");
		if(checkLobby(p)){
			path.delete();
			try {
				path.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addLobbyDump(p, l);
		} else {
			try {
				path.createNewFile();
				addLobbyDump(p, l);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void addLobbyDump(Player p, Location l){
		try {
			File f = new File(root + File.separator + p.getName() + ".lobbydata");
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
	
	public void removeLobbyDumpFile(Player p){
		File f = new File(root + File.separator + p.getName() + ".lobbydata");
		f.delete();
	}
	
	public Location getLobbyDump(Player p){
		File f = new File(root + File.separator + p.getName() + ".lobbydata");
		Configuration c = new Configuration(f);
		c.load();
		World w = Warzone.server.getWorld(c.getString("World").toString());
		double x = c.getDouble("X", 0), y = c.getDouble("Y", 0), z = c.getDouble("Z", 0);
		return new Location(w, x, y, z);
	}

}
