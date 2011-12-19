package couk.Adamki11s.Database;

import java.io.File;
import couk.Adamki11s.Lobby.SoloPool;

public class PoolDataLoader {
	
	SettingsHandler poolTimes = new SettingsHandler("ConfigurationFiles/Matchmaking.config", "plugins" + 
			 File.separator +  "Warzone" + File.separator +"Configuration"  + File.separator + "MatchMaking.config");
	
	public void loadPoolingData(){
		poolTimes.load();
		SoloPool.timeout_Count = poolTimes.getPropertyInteger("TimeoutCount");
		SoloPool.sendSearchMessageEvery_XSeconds = poolTimes.getPropertyInteger("SearchMessageDialogueDisplayRate");
		SoloPool.showTOC = poolTimes.getPropertyBoolean("ShowTOC");
		CoreConfiguration.coalAMT = poolTimes.getPropertyInteger("CoalAmount");
		System.out.println("[Warzone] Matchmaking configuration loaded successfully!");
	}

}
