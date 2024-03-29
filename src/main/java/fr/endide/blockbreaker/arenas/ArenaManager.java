package fr.endide.blockbreaker.arenas;

import fr.endide.blockbreaker.Blockbreaker;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ArenaManager {
    boolean isWorldGenerate = false;
	private Blockbreaker main;
	public ArenaManager(Blockbreaker main) {
		this.main = main;
	}
	private List<Arena> arenas = new ArrayList<>();
	public void addArena(Arena arena) {
		this.arenas.add(arena);
	}
	public void joinArena(Player firstPlayer) {
		Arena nextArena = getNextArena();
		if(nextArena != null)
		{
			nextArena.getPlayers().add(firstPlayer);
			firstPlayer.sendMessage("$cVous avez rejoins une arene");
			Location loc = new Location(Bukkit.getWorld("world"), 0, 140, 0);
			firstPlayer.teleport(loc);
			main.arenaManager.TeamSplit(firstPlayer);
			firstPlayer.getInventory().clear();
			firstPlayer.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
			firstPlayer.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE, 1));
			firstPlayer.getInventory().addItem(new ItemStack(Material.WOOD_AXE, 1));
			firstPlayer.getInventory().addItem(new ItemStack(Material.WOOD_SPADE, 1));
			nextArena.setScoreboard(firstPlayer);
			firstPlayer.sendMessage("§8-----§3Bienvenue dans Block Breaker§8-----");
			firstPlayer.sendMessage("§8--------§cMais quel est le but ?§8--------");
			firstPlayer.sendMessage("");
			firstPlayer.sendMessage("§3Vous devez vous et votre équipe détruire le plus de blocs");
			firstPlayer.sendMessage("§3Si vous arriver a 1000 blocs alors vous avez gagner");
			firstPlayer.sendMessage("");
			firstPlayer.sendMessage("§3Mais il y a quelques mechaniques qui pimenteront le jeu :");
			firstPlayer.sendMessage("");
			firstPlayer.sendMessage("§7-§3Quand vous casser des blocs vos Outils s'améliorent");
			firstPlayer.sendMessage("§7-§3Quand vous tuez des gens votre épée s'améliore");
			firstPlayer.sendMessage("§7-§3Mais si vous mourrez vous perdrez tout vos point d'amélioration(PointTools)");
			firstPlayer.sendMessage("");
			firstPlayer.sendMessage("§7-§3Vous avez acc�s au shop avec /bbrshop");
			firstPlayer.sendMessage("§3Vous pourrez echanger des choses contre des minerais");
			firstPlayer.sendMessage("");
			firstPlayer.sendMessage("§3Voila les regles de bases n'oubliez pas que vous pouvez faire des stratégies");
			firstPlayer.sendMessage("§3Sur ce bonne chance la partie ne devrait pas tarder a commencer");
			if(nextArena.getPlayers().size() == 2) {
				for(Player p : Bukkit.getOnlinePlayers()){
				    if(p.getWorld().getName().equals("world")){
				        if(PlayerIsOnArena(p)) {
				        	p.teleport(nextArena.getFirstLoc());
				        }
				    }
				}
				nextArena.setStarted();
			}
		}
		else {
			if(isWorldGenerate == false) {
			isWorldGenerate = true;
			firstPlayer.sendMessage("§cIl n'y a aucune arenes disponible, Création d'une arene en cours...");
			WorldCreator wc = new WorldCreator(firstPlayer.getName() + "BlockBreaker");
			wc.environment(World.Environment.NORMAL);
			wc.type(WorldType.NORMAL);
			wc.createWorld();
            World world = Bukkit.getWorld(firstPlayer.getName() + "BlockBreaker");
			WorldBorder border = world.getWorldBorder();
			border.setSize(100.0);
			border.setCenter(0.0, 0.0);
			main.getConfig().set("arenas." + firstPlayer.getName() + "BlockBreaker" + ".loc1", "0,100,0");
			main.getConfig().set("arenas." + firstPlayer.getName() + "BlockBreaker" + ".world", firstPlayer.getName() + "BlockBreaker");
			main.getConfig().set("arenas." + firstPlayer.getName() + "BlockBreaker" + ".bluePlayers", 0);
			main.getConfig().set("arenas." + firstPlayer.getName() + "BlockBreaker" + ".redPlayers", 0);
			main.saveConfig();
			isWorldGenerate = false;
			main.GetArenaList();
			main.arenaManager.joinArena(firstPlayer);
			}else {
				firstPlayer.sendMessage("§cIl n'y a aucune arenes disponible et une arene est en train d'etre créer veuillez recommencer dans 30 secondes");
			}

		}
	}
	public Arena getArenaByPlayer(Player player) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				return arena;
			}
		}
		return null;
	}
	public boolean getArenaIsStarted(Player player) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				if(arena.isStarted() == true) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean PlayerIsOnArena(Player player) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				return true;
			}
		}
		return false;
	}

	public int BlueCounterOnArena(Player player,int point) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				arena.blueScore(player, +point);

			}
		}
		return point;
	}
	public int RedCounterOnArena(Player player, int point) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				arena.redScore(player, +point);

			}
		}
		return point;
	}


	private Arena getNextArena() {

		for(Arena arena : arenas)
		{
			if(!arena.isStarted())
			{
				return arena;
			}
		}

		return null;
	}
	public List<Arena> getArenas(){
		return arenas;
	}

	@SuppressWarnings("deprecation")
	public void TeamSplit(Player player) {
		for(Arena arena : arenas) {
	      if(arena.getPlayers().contains(player)) {
			if(arena.teamRed.getSize() == 1) {
				arena.teamBlue.addPlayer(player);
				player.sendMessage("Vous etes blue");
			    }else {
			    arena.teamRed.addPlayer(player);
			    player.sendMessage("Vous etes red");
				}
			}
		}
    }
	@SuppressWarnings("deprecation")
	public String PlayerTeam(Player player) {
		for(Arena arena : arenas) {
	      if(arena.getPlayers().contains(player)) {
			if(arena.teamRed.hasPlayer(player) == true) {
				return "Rouge";
			    }else {
			    return "Bleu";
				}
			}
		}
		return null;
    }
	public void PlayerQuit(Player player) {
		for(Arena arena : arenas) {
			if(arena.getPlayers().contains(player)) {
				String name = player.getName();
			    Location loc = new Location(Bukkit.getWorld("world"), 0, 140, 0);
				player.teleport(loc);
				main.getConfig().set(name, null);
				main.saveConfig();
				player.getInventory().clear();
				if(arena.teamRed.hasPlayer(player) == true) {
					arena.teamRed.removePlayer(player);

				}else {
					arena.teamBlue.removePlayer(player);
					}
				}
			}
		}
}
