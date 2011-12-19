package couk.Adamki11s.SpoutInterface;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.event.spout.SpoutListener;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericWidget;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.gui.PopupScreen;
import org.getspout.spoutapi.player.SpoutPlayer;

public class SpoutCraftListener extends SpoutListener {
	
	@Override
    public void onSpoutCraftEnable(SpoutCraftEnableEvent event) {
        SpoutData.spoutEnabled.put(((Player)event.getPlayer()), true);
        drawGUI(event.getPlayer());
    }
	
	  private void drawGUI(SpoutPlayer sp) {
		  InGameHUD hub = sp.getMainScreen();
	        GenericLabel fundsLabel = new GenericLabel("Warzone"), label2 = new GenericLabel("LOL");
	        fundsLabel.setHexColor(Integer.parseInt("CD0000", 16)).setX(1).setY(1);
	        label2.setHexColor(Integer.parseInt("CD0000", 16)).setX(1).setY(10);
	        InGameHUD HUD = sp.getMainScreen();
	        sp.getMainScreen().attachWidget(fundsLabel);
	        sp.sendNotification("NOT 1", "NOT 2fdgdh", Material.ARROW);	  
	  }

}
