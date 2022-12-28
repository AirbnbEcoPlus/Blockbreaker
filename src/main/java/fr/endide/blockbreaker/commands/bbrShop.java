package fr.endide.blockbreaker.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class bbrShop implements CommandExecutor {
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		Player player = (Player) sender ;
		Inventory bbrinv = Bukkit.createInventory(null, 9, "§8BlockBreakerSHOP");

		ItemStack tnt = new ItemStack(Material.TNT, 1);
		ItemMeta tntM = tnt.getItemMeta();
		tntM.setDisplayName("TNT");
		tntM.setLore(java.util.Arrays.asList("§7Couts: ", "- 2 Charbon", "- 8 Sable"));
		tnt.setItemMeta(tntM);

		ItemStack  armor = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta armorM = tnt.getItemMeta();
		armorM.setLore(java.util.Arrays.asList("§7Couts: ", "- 10 Fer", "- 2 Or"));
		armorM.setDisplayName("Armure de Fer");
		armor.setItemMeta(armorM);

		bbrinv.setItem(0, tnt);
		bbrinv.setItem(1, armor);
		player.openInventory(bbrinv);

		return false;
	}
}
