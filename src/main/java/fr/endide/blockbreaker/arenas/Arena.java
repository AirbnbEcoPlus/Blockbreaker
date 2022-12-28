package fr.endide.blockbreaker.arenas;

import fr.endide.blockbreaker.Blockbreaker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    public ScoreboardManager manager = Bukkit.getScoreboardManager();
	public Scoreboard board;
	public Team teamRed;
	public Team teamBlue;
	public Objective Point;
	public Score Redscore;
	public Score Bluescore;
	private Blockbreaker main;
	public Arena(Blockbreaker main) {
		this.main = main;
	}


	private Location loc1;
	private List<Player> players;
	private String ArenaName;
	private boolean isStarted;
	private int redCounter;
	private int blueCounter;

	public Arena(Location loc1) {
		this.loc1 = loc1;
		this.players = new ArrayList<>();
		this.isStarted = false;
		this.redCounter = 0;
		this.blueCounter = 0;
		this.board = manager.getNewScoreboard();
		this.teamRed = board.registerNewTeam("Red");
		this.teamBlue = board.registerNewTeam("Blue");
		this.Point = board.registerNewObjective("Score", "dummy");
		this.Bluescore = Point.getScore(ChatColor.RED + "Rouge");
		this.Redscore = Point.getScore(ChatColor.BLUE + "Bleu");
		this.teamRed.setAllowFriendlyFire(false);
		this.teamBlue.setAllowFriendlyFire(false);
	}


	public Location getFirstLoc() {

		return loc1;
	}
	public String ArenaName(String Name) {
		ArenaName = Name;
		return ArenaName;
	}
	public List<Player> getPlayers(){
		return players;
	}
	public boolean isStarted() {
		return isStarted;
	}
	public void setScoreboard(Player player){
		Point.setDisplaySlot(DisplaySlot.SIDEBAR);
		Point.setDisplayName("Point");
		player.setScoreboard(this.board);
	}
	public void setStarted() {
		this.isStarted = true;
	}
	public int redScore(Player player,int point){
		this.redCounter += point;
		this.Redscore.setScore(this.redCounter);
		if(this.redCounter == 2000) {
		     player.sendMessage("L'équipe Rouge a gagnée merci d'avoir jouer");
		     restart(player);
		}
		return redCounter;
	}
	public int blueScore(Player player,int point){
		this.blueCounter += point;
		this.Bluescore.setScore(this.blueCounter);
        if(this.blueCounter == 2000) {
        	player.sendMessage("L'�quipe Bleu a gagnée merci d'avoir jouer");
        	restart(player);
		}
		return blueCounter;

	}

	private void restart(Player player) {
		players.clear();
		World world = player.getWorld();
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "world evacuate " + world.getName());
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "world delete " + world.getName());
		this.players = new ArrayList<>();
		this.isStarted = false;
		this.redCounter = 0;
		this.blueCounter = 0;
		main.getConfig().set(world.getName(), null);
	}
}
