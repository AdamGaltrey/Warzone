package couk.Adamki11s.SpoutInterface;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class SpoutStartup {		
	
	public SpoutStartup(PluginManager pm, Logger log){
		Plugin p = pm.getPlugin("Spout");
		if(p == null){
			SpoutData.global_spoutEnabled = false;
			log.info("[Warzone] Spout was not found. Spout support disabled!");
		} else {
			SpoutData.global_spoutEnabled = true;
			log.info("[Warzone] Spout detected! Spout support enabled!");
		}
	}

}
