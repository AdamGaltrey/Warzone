package couk.Adamki11s.SpoutInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.gui.Widget;
import org.getspout.spoutapi.player.SpoutPlayer;

import couk.Adamki11s.Extras.Random.ExtrasRandom;

public class GUI_Wrapper {
	
	public static HashMap<Player, Widget> yourScoreWidget = new HashMap<Player, Widget>();
	public static HashMap<Player, Widget> theirScoreWidget = new HashMap<Player, Widget>();
	public static HashMap<Player, Widget> timeWidget = new HashMap<Player, Widget>();
	public static HashMap<Player, Widget> warzoneWidget = new HashMap<Player, Widget>();
	
	ExtrasRandom er = new ExtrasRandom();
	
	public void paintWarzone(SpoutPlayer sp){
		if(!warzoneWidget.containsKey((Player)sp)){
			GenericLabel scorelabel = new GenericLabel("Warzone");
	        scorelabel.setHexColor(Integer.parseInt(HashCode.RED.getHash(), 16)).setX(WindowCoordinates.TOP_LEFT.xcoord).setY(WindowCoordinates.TOP_LEFT.ycoord);
	        sp.getMainScreen().attachWidget(scorelabel);
	        warzoneWidget.put((Player)sp, scorelabel);
		} else {
			Widget w = warzoneWidget.get((Player)sp);
			if(w instanceof GenericLabel){
				GenericLabel gl = (GenericLabel)w;
				gl.setText("Warzone");
				gl.render();
				gl.setDirty(true);
			}
		}
	}
	
	public void paintYourPlayerScore(SpoutPlayer sp, int score){
		if(!yourScoreWidget.containsKey((Player)sp)){
			GenericLabel scorelabel = new GenericLabel(sp.getName() + " : " + score);
	        scorelabel.setHexColor(Integer.parseInt(HashCode.GREEN.getHash(), 16)).setX(WindowCoordinates.TL_PRIMARY_SCORE.xcoord).setY(WindowCoordinates.TL_PRIMARY_SCORE.ycoord);
	        sp.getMainScreen().attachWidget(scorelabel);
	        yourScoreWidget.put((Player)sp, scorelabel);
		} else {
			Widget w = yourScoreWidget.get((Player)sp);
			if(w instanceof GenericLabel){
				GenericLabel gl = (GenericLabel)w;
				gl.setText(sp.getName() + " : " + score);
				gl.render();
				gl.setDirty(true);
			}
		}
	}
	
	public void paintYourOpponentScore(SpoutPlayer sp, Player opponent, int score){
		if(!theirScoreWidget.containsKey((Player)sp)){
			GenericLabel scorelabel = new GenericLabel(opponent.getName() + " : " + score);
	        scorelabel.setHexColor(Integer.parseInt(HashCode.DARK_RED.getHash(), 16)).setX(WindowCoordinates.TL_SECONDARY_SCORE.xcoord).setY(WindowCoordinates.TL_SECONDARY_SCORE.ycoord);
	        sp.getMainScreen().attachWidget(scorelabel);
	        theirScoreWidget.put((Player)sp, scorelabel);
		} else {
			Widget w = theirScoreWidget.get((Player)sp);
			if(w instanceof GenericLabel){
				GenericLabel gl = (GenericLabel)w;
				gl.setText(opponent.getName() + " : " + score);
				gl.render();
				gl.setDirty(true);
			}
		}
	}
	
	public void paintTime(SpoutPlayer sp, int time){
		if(!timeWidget.containsKey((Player)sp)){
			GenericLabel timelabel = new GenericLabel("Time remaining : " + time + " s.");
			timelabel.setHexColor(Integer.parseInt(HashCode.YELLOW.getHash(), 16)).setX(WindowCoordinates.TL_TIME_LEFT.xcoord).setY(WindowCoordinates.TL_TIME_LEFT.ycoord);
	        sp.getMainScreen().attachWidget(timelabel);
	        timeWidget.put((Player)sp, timelabel);
		} else {
			Widget w = timeWidget.get((Player)sp);
			if(w instanceof GenericLabel){
				GenericLabel gl = (GenericLabel)w;
				gl.setText("Time remaining : " + time + "s");
				gl.render();
				gl.setDirty(true);
			}
		}
	}
	
	public void clearPlayerWidgets(SpoutPlayer sp){
		
	}
	
	public static enum WindowCoordinates{
		TOP_LEFT(1, 1),
		TL_PRIMARY_SCORE(1, 11),
		TL_SECONDARY_SCORE(1, 21),
		TL_TIME_LEFT(1, 31),
		TOP_RIGHT(427, 1),
		BOTTOM_LEFT(1, 240),
		BOTTOM_RIGHT(427, 240);
		
		public int xcoord, ycoord;
		
		WindowCoordinates(int xcoord, int ycoord){
			this.xcoord = xcoord;
			this.ycoord = ycoord;
		}
	}
	
	public static enum HashCode{
		TERRACOTTA("CD5555"),
		RED("CD0000"),
		DARK_RED("8B0000"),
		DARK_ORANGE("FF7F00"),
		ORANGE("FF6600"),
		PALE_YELLOW("FCD116"),
		YELLOW("FFE303"),
		LIGHT_GREEN("C0FF3E"), //Coffee XD
		DARK_GREEN("385E0F"),
		GREEN("AADD00"),
		BRIGHT_GREEN("7CFC00"),
		SEA_GREEN("2E8B57"),
		DARK_TEAL("20B2AA"),
		CYAN("00FFCC"),
		BLUE("0276FD"),
		DARK_BLUE("1B3F8B");
		
		HashCode(String hashcode){
	        this.hashcode = hashcode;
	    }
		
		public String getHash(){
			return this.hashcode;
		}
		
		private final String hashcode;
		
		public String getHashCode(){
			return hashcode;
		}
		
		@Override
		public String toString(){
			return super.toString().substring(0, 1).toUpperCase() + super.toString().toLowerCase().substring(1, super.toString().length());
		}
	}

}
