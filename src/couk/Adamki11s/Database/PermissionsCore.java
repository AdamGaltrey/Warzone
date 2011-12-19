package couk.Adamki11s.Database;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

import couk.Adamki11s.Warzone.Warzone;

public class PermissionsCore {
	
	private PermissionHandler permissionHandler;
	private boolean hasPermissions = false;
	
	
	
	public boolean doesHaveNode(Player p, String node){
		if(hasPermissions){
			if(permissionHandler.has(p, node)){
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}
	
	public void sendInsufficientPermsMsg(Player p){
		p.sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("You do not have permissions to do this!"));
	}
	
	public boolean doesHaveSuperNode(Player p, String node){
		if(hasPermissions){
			if(permissionHandler.has(p, node) || p.isOp()){
				return true;
			} else {
				return false;
			}
		} else if(p.isOp()){
			return true;
		} else {
			return false;
		}
	}
	
	public void setupPermissions() {
	      Plugin permissionsPlugin = Warzone.server.getPluginManager().getPlugin("Permissions");
	      if (this.permissionHandler == null) {
	          if (permissionsPlugin != null) {
	              this.permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	              hasPermissions = true;
	              System.out.println("[Warzone] Version " + Warzone.version + " - Permissions support enabled");
	          } else {
	        	  System.out.println("[Warzone] Version " + Warzone.version + " - Permissions not detected.");
	          }
	      }
	  }

}
