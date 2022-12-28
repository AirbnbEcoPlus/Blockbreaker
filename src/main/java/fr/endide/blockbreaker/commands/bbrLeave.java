package fr.endide.blockbreaker.commands;

import fr.endide.blockbreaker.Blockbreaker;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class bbrLeave implements CommandExecutor {
    private Blockbreaker main;
	public bbrLeave(Blockbreaker main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
		main.arenaManager.PlayerQuit(player);
		player.sendMessage("Vous avez quitter BlockBreaker, Merci d'avoir jouer");
		return false;

	}
}
