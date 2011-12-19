package couk.Adamki11s.Games.Solo;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import couk.Adamki11s.SpoutInterface.GUI_Wrapper;
import couk.Adamki11s.SpoutInterface.SpoutData;
import couk.Adamki11s.Warzone.Warzone.GameType;

public abstract class Gamedata {
	
	private final GUI_Wrapper guiw = new GUI_Wrapper();
	private final SpoutData spoutData = new SpoutData();
	
	public abstract void initiateScheduler();
	
	public abstract void initiateGame(ArrayList<Player> list);
	
	public abstract void addParticipant(Player p);
	
	public abstract void removeParticipants(Player p);
	
	public abstract void shotFired(Player p);
	
	public abstract void shotMissed(Player p);
	
	public abstract void swordStruck(Player p, Player target);
	
	public abstract void shotHit(Player p, Player target);
	
	public abstract void incrementPlayerScore(Player p);
	
	public abstract Player getWinner();
	
	public abstract Player getLooser();
	
	public abstract String getName();
	
	public abstract void tickerTask(int schedulerTask);
	
	public abstract void endGame(int taskid);
	
	public abstract void saveData(ArrayList<Player> partic);
	
	public abstract ArrayList<Player> getParticipants();
	
	public abstract void respawn();
	
	public abstract void passGameType(GameType gt);
	
	public abstract void updateSigns();
	
	public void updateGUIWrapper(Player p1, Player p2, int timeleft, int playerscore1, int playerscore2){
		SpoutPlayer sp1 = (SpoutPlayer)p1, sp2 = (SpoutPlayer)p2;
			if(spoutData.doesPlayerHaveSpout(sp1)){
				guiw.paintWarzone(sp1);
				guiw.paintYourPlayerScore(sp1, playerscore1);
				guiw.paintYourOpponentScore(sp1, p2, playerscore2);
				guiw.paintTime(sp1, timeleft);
			}
			if(spoutData.doesPlayerHaveSpout(sp2)){
				guiw.paintWarzone(sp2);
				guiw.paintYourPlayerScore(sp2, playerscore2);
				guiw.paintYourOpponentScore(sp2, p1, playerscore1);
				guiw.paintTime(sp2, timeleft);
			}
	}
	
	public void clearWidgets(SpoutPlayer sp){
		guiw.clearPlayerWidgets(sp);
	}

}
