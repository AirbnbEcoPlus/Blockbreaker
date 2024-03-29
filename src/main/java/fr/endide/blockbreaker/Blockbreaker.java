package fr.endide.blockbreaker;

import fr.endide.blockbreaker.arenas.Arena;
import fr.endide.blockbreaker.arenas.ArenaManager;
import fr.endide.blockbreaker.commands.bbrJoin;
import fr.endide.blockbreaker.commands.bbrLeave;
import fr.endide.blockbreaker.commands.bbrShop;
import fr.endide.blockbreaker.listen.bbrBlockCounter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

public final class Blockbreaker extends JavaPlugin {
    public ArenaManager arenaManager = new ArenaManager(this);
    public void onEnable(){
		saveDefaultConfig();
		System.out.println("Merci d'utiliser BlockBreaker");
		getCommand("bbrjoin").setExecutor(new bbrJoin(this));
		getCommand("bbrleave").setExecutor(new bbrLeave(this));
		getCommand("bbrshop").setExecutor(new bbrShop());
		getServer().getPluginManager().registerEvents(new bbrBlockCounter(this), this);
		if(getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

	}
	public void GetArenaList(){

	    ConfigurationSection arenaSection = getConfig().getConfigurationSection("arenas");
	    for(String string : arenaSection.getKeys(false)) {
	    	String loc1 = arenaSection.getString(string + ".loc1");
	    	String world = arenaSection.getString(string + ".world");
	    	Arena arena = new Arena(parseStringToLoc(loc1, world));
	    	arenaManager.addArena(arena);

	    }

	}
	public ArenaManager getArenaManager() {
		return arenaManager;
	}
	public Location parseStringToLoc(String string, String world) {
		String[] parsedLoc = string.split(",");
		double x = Double.valueOf(parsedLoc[0]);
		double y = Double.valueOf(parsedLoc[1]);
		double z = Double.valueOf(parsedLoc[2]);

		return new Location(Bukkit.getWorld(world), x,y,z);
	}
}
