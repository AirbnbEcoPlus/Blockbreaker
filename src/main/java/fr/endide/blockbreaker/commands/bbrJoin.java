package fr.endide.blockbreaker.commands;

import fr.endide.blockbreaker.Blockbreaker;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class bbrJoin implements CommandExecutor {
    private Blockbreaker main;
	public bbrJoin(Blockbreaker main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		Player player = (Player) sender;
	    String name = player.getName();
			if(main.arenaManager.PlayerIsOnArena(player) == false){
    			main.getConfig().createSection(name);
    			main.getConfig().set(name + ".pioche", 0);
    			main.getConfig().set(name + ".hache", 0);
    			main.getConfig().set(name + ".pelle", 0);
    			main.getConfig().set(name + ".epee", 0);
    			main.saveConfig();
    			main.arenaManager.joinArena(player);
			}else {
				player.sendMessage("�3Vous etes deja dans une arene");
			}
		return false;
	}
}
