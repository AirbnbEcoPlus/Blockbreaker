package fr.endide.blockbreaker.listen;

import fr.endide.blockbreaker.Blockbreaker;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class bbrBlockCounter implements Listener {
    private Blockbreaker main;
	public bbrBlockCounter(Blockbreaker main) {
		this.main = main;
	}
	@EventHandler(priority = EventPriority.HIGH)
	public void onBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		String name = player.getName();
		Block block = event.getBlock();
		if(main.arenaManager.PlayerIsOnArena(player)) {
	      if(main.arenaManager.getArenaIsStarted(player)) {
		  	upgradeTools(player);
			if(block.getType() == Material.STONE) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 2);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();

				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 2);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.DIRT) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.GRASS) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.LOG) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 2);
					int helpcounter = main.getConfig().getInt(name + ".hache");
					main.getConfig().set(name + ".hache",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 2);
					int helpcounter = main.getConfig().getInt(name + ".hache");
					main.getConfig().set(name + ".hache",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.SAND) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 1);
					int helpcounter = main.getConfig().getInt(name + ".pelle");
					main.getConfig().set(name + ".pelle",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.OBSIDIAN) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 15);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 15);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.IRON_ORE) {

				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 3);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 3);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.GOLD_ORE) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 5);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 5);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.DIAMOND) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {
					main.arenaManager.RedCounterOnArena(player, 8);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 8);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
			if(block.getType() == Material.IRON_ORE) {
				if(main.arenaManager.PlayerTeam(player) == "Rouge") {

				    main.arenaManager.RedCounterOnArena(player, 4);
				    int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();


				}

				if(main.arenaManager.PlayerTeam(player) == "Bleu") {
					main.arenaManager.BlueCounterOnArena(player, 4);
					int helpcounter = main.getConfig().getInt(name + ".pioche");
					main.getConfig().set(name + ".pioche",helpcounter + 1);
					main.saveConfig();
				}
			}
		}
		}
	  }





    private void upgradeTools(Player player) {
    	String name = player.getName();
    	if(main.getConfig().getLong(name + ".pioche") == 40) {
    		if(player.getInventory().contains(Material.WOOD_PICKAXE)) {
    		player.getInventory().remove(Material.WOOD_PICKAXE);
    		player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
    		player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pioche, votre pioche s'améliore");

		  }
    	}
		if(main.getConfig().getLong(name + ".pioche") == 80) {
			if(player.getInventory().contains(Material.STONE_PICKAXE)) {
			player.getInventory().remove(Material.STONE_PICKAXE);
			player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE, 1));
    		player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pioche, votre pioche s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".pioche") == 120) {
			if(player.getInventory().contains(Material.IRON_PICKAXE)) {
			player.getInventory().remove(Material.IRON_PICKAXE);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
    		player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pioche, votre pioche s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".hache") == 40) {
			if(player.getInventory().contains(Material.WOOD_AXE)) {
			player.getInventory().remove(Material.WOOD_AXE);
			player.getInventory().addItem(new ItemStack(Material.STONE_AXE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre hache, votre hache s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".hache") == 80) {
			if(player.getInventory().contains(Material.STONE_AXE)) {
			player.getInventory().remove(Material.STONE_AXE);
			player.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre hache, votre hache s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".hache") == 120) {
			if(player.getInventory().contains(Material.IRON_AXE)) {
			player.getInventory().remove(Material.IRON_AXE);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre hache, votre hache s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".pelle") == 40) {
			if(player.getInventory().contains(Material.WOOD_SPADE)) {
			player.getInventory().remove(Material.WOOD_SPADE);
			player.getInventory().addItem(new ItemStack(Material.STONE_SPADE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pelle, votre pelle s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".pelle") == 80) {
			if(player.getInventory().contains(Material.STONE_SPADE)) {
			player.getInventory().remove(Material.STONE_SPADE);
			player.getInventory().addItem(new ItemStack(Material.IRON_SPADE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pelle, votre pelle s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".pelle") == 120) {
			if(player.getInventory().contains(Material.IRON_SPADE)) {
			player.getInventory().remove(Material.IRON_SPADE);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND_SPADE, 1));
			player.sendMessage("Bravo vous avez casser beaucoup de blocs avec votre pelle, votre pelle s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".epee") == 30) {
			if(player.getInventory().contains(Material.WOOD_SWORD)) {
			player.getInventory().remove(Material.WOOD_SWORD);
			player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
			player.sendMessage("Triple Kill, votre épée s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".epee") == 60) {
			if(player.getInventory().contains(Material.STONE_SWORD)) {
			player.getInventory().remove(Material.STONE_SWORD);
			player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
			player.sendMessage("Vous faites un massacre, votre épée s'améliore");
		  }
		}
		if(main.getConfig().getLong(name + ".epee") == 120) {
			if(player.getInventory().contains(Material.IRON_SWORD)) {
			player.getInventory().remove(Material.IRON_SWORD);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
			player.sendMessage("Vous etes un dieu de l'épée, c'est un massacre, votre épée s'améliore");
		  }
		}

	}
    public void onPlayerRepsawn (PlayerRespawnEvent event) {
    	Player player = event.getPlayer();
    	String name = player.getName();
    	if(main.arenaManager.PlayerIsOnArena(player)== false) {

  	    	player.sendMessage("Vous avez été tuez vous perder tout vos pointTools et votre inventaire");
			player.getInventory().clear();
			player.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
			player.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE, 1));
			player.getInventory().addItem(new ItemStack(Material.WOOD_AXE, 1));
			player.getInventory().addItem(new ItemStack(Material.WOOD_SPADE, 1));
			main.getConfig().set(name + ".pioche", 0);
			main.getConfig().set(name + ".hache", 0);
			main.getConfig().set(name + ".pelle", 0);
			main.getConfig().set(name + ".epee", 0);
			main.saveConfig();

    	}
    }
	@EventHandler
    public void onPlayerDead (PlayerDeathEvent event) {
    	Player killed = event.getEntity().getPlayer();
    	Player killer = event.getEntity().getKiller();
    	String name = killer.getName();
    	if(main.arenaManager.PlayerIsOnArena(killed) == false) {
        if (event.getEntity() instanceof Player) {

        }
        if (event.getEntity().getKiller() instanceof Player) {
        	killer.sendMessage("Bravo vous avez tuez une personne adverse");
        	main.arenaManager.BlueCounterOnArena(killer, 15);
        	int helpcounter = main.getConfig().getInt(name + ".epee");
        	main.getConfig().set(name + ".epee",helpcounter +15);
        	upgradeTools(killer);
        }
        }
    }
	@EventHandler
	public void onClick(InventoryClickEvent event) {
			Inventory inv = event.getInventory();
			Player player = (Player) event.getWhoClicked();
			ItemStack current = event.getCurrentItem();
			if(current == null) return;
			if(inv.getName().equalsIgnoreCase("§8BlockBreakerSHOP")) {
				if(current.getType() == Material.TNT) {
					event.setCancelled(true);
					if(player.getInventory().contains(Material.SAND, 8)) {
						if(player.getInventory().contains(Material.COAL, 2)) {
							player.getInventory().remove(Material.SAND);
							player.getInventory().remove(Material.COAL);
							player.getInventory().addItem(new ItemStack(Material.TNT));
							player.getInventory().addItem(new ItemStack(Material.FLINT_AND_STEEL));
                     }
		       }else {
		    	   player.sendMessage("Vous n'avez pas les Materiaux necessaire");
		       }
			}
				if(current.getType() == Material.IRON_CHESTPLATE) {
					event.setCancelled(true);
					if(player.getInventory().contains(Material.IRON_INGOT, 8)) {
						if(player.getInventory().contains(Material.GOLD_INGOT, 2)) {
							player.getInventory().remove(Material.IRON_INGOT);
							player.getInventory().remove(Material.GOLD_INGOT);
							player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
							player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
							player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
							player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));

						}
		       }else {
		    	   player.sendMessage("Vous n'avez pas les Materiaux necessaire");
		       }
			}
			}
		}
}
