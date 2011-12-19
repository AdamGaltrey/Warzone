package couk.Adamki11s.Database;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.config.Configuration;

public class InventoryData {
	
	private File mainDir = new File("plugins/Warzone"),
	inventoryRoot = new File(mainDir + File.separator + "Inventory");
	
	public void saveInventory(Player p, ItemStack[] iss){
		checkFile(p);
		Configuration c = new Configuration(new File(inventoryRoot + File.separator + p.getName() + ".inv"));
		int index = 0;
		for(ItemStack is : iss){
			if(is != null){
				c.setProperty("Inventory.Slot.Type." + index, iss[index].getType().toString());
				c.setProperty("Inventory.Slot.Amount." + index, iss[index].getAmount());
			} else {
				c.setProperty("Inventory.Slot.Type." + index, Material.AIR.toString());
				c.setProperty("Inventory.Slot.Amount." + index, 0);
			}
			index++;
		}
		c.save();
	}
	
	public ItemStack[] loadInventory(Player p){
		Configuration c = new Configuration(new File(inventoryRoot + File.separator + p.getName() + ".inv"));
		ItemStack[] invent = new ItemStack[36];
		
		c.load();
		for(int i = 0; i < 36; i++){
			Material m = Material.getMaterial(c.getString("Inventory.Slot.Type." + i, Material.AIR.toString()));
			int amount = c.getInt("Inventory.Slot.Amount." + i, 0);
			if(m != Material.AIR && amount > 0){
				invent[i] = new ItemStack(m, amount);
			} else {
				invent[i] = null;
			}
		}
		
		return invent;
	}
	
	public boolean isInNeedOfInventoryLoading(Player p){
		File tmp = new File(inventoryRoot + File.separator + p.getName() + ".inv");
		if(tmp.exists()){
			return true;
		} else {
			return false;
		}
	}
	
	public void checkFile(Player p){
		File tmp = new File(inventoryRoot + File.separator + p.getName() + ".inv");
		if(tmp.exists()){
			tmp.delete();
		} else {
			try {
				tmp.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
