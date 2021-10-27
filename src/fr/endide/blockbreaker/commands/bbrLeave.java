package fr.endide.blockbreaker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.endide.blockbreaker.Main;

public class bbrLeave implements CommandExecutor {

	private Main main;
	public bbrLeave(Main main) {
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
