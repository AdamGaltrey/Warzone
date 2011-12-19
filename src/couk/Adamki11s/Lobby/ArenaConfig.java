package couk.Adamki11s.Lobby;

import java.io.File;
import java.io.IOException;

import org.bukkit.util.config.Configuration;

import couk.Adamki11s.Warzone.Warzone;

public class ArenaConfig {
	
	private File root = new File("plugins/Warzone/Configuration");
	
	public void createAC(){
		File f = new File(root + File.separator + "LobbyConfig.yml");
		if(!f.exists()){
			try {
				f.createNewFile();
				Configuration c = new Configuration(f);
				c.setProperty("NPCSpawnInLobby", true);
				Warzone.doNPCSpawn = true;
				c.save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			loadAC();
		}
	}

	private void loadAC() {
		File f = new File(root + File.separator + "LobbyConfig.yml");
		Configuration c = new Configuration(f);
		c.load();
		Warzone.doNPCSpawn = c.getBoolean("NPCSpawnInLobby", true);
		c.save();
	}

}
