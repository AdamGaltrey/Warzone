package couk.Adamki11s.Warzone;

import org.bukkit.ChatColor;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import couk.Adamki11s.Maps.Maps;

public class WarzoneBlockListener extends BlockListener {
	
	public void onBlockBreak(BlockBreakEvent evt){
		if(evt.getPlayer().getWorld() == Maps.Warzone_World){
		evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("The warzone world is not editable!"));
		evt.setCancelled(true);
	}
	}
	
	public void onBlockPlace(BlockPlaceEvent evt){
		if(evt.getPlayer().getWorld() == Maps.Warzone_World){
			evt.getPlayer().sendMessage(ChatColor.RED + "[Warzone] " + Warzone.li.getObj("The warzone world is not editable!"));
			evt.setCancelled(true);
		}
	}
	
	public void onLeavesDecay(LeavesDecayEvent evt){
		if(evt.getBlock().getWorld() == Maps.Warzone_World){
			evt.setCancelled(true);
		}
	}
	
	public void onBlockForm(BlockFormEvent evt){
		if(evt.getBlock().getWorld() == Maps.Warzone_World){
			 if (((evt.getNewState().getTypeId() == 78) || ((evt.getNewState().getTypeId() == 79)))){
				 evt.setCancelled(true);
			 }
		}
			        
	}


}
