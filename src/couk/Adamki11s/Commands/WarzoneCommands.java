package couk.Adamki11s.Commands;

import java.text.DecimalFormat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import couk.Adamki11s.Database.LobbyPlaceHolder;
import couk.Adamki11s.Database.PermissionsCore;
import couk.Adamki11s.Database.PlayerReturnHandler;
import couk.Adamki11s.Database.Preferences;
import couk.Adamki11s.SpoutInterface.GUI_Wrapper;

public class WarzoneCommands implements CommandExecutor{
	
	DecimalFormat lvlFormat = new DecimalFormat("#0");
	
	Preferences pref = new Preferences();
	
	LobbyPlaceHolder lph = new LobbyPlaceHolder();
	
	PlayerReturnHandler prh = new PlayerReturnHandler();
	
	PermissionsCore pc = new PermissionsCore();
	
	SearchCommands searchCMD = new SearchCommands();
	StatisticsCommands statsCMD = new StatisticsCommands();
	PreferencesCommands prefsCMD = new PreferencesCommands();
	AdminCommands adminCMD = new AdminCommands();


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(label.equalsIgnoreCase("warzone") || label.equalsIgnoreCase("wz")){							
				
				searchCMD.check(p, args);
				
				statsCMD.check(p, args);
				
				prefsCMD.check(p, args);
				
				adminCMD.check(p, args);
									
				return true;
			}
		}
		return true;
	}

}
