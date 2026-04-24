package me.datatags.constanthunger.listeners;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import java.util.concurrent.TimeUnit;


public class RespawnListener implements Listener {

	public ConstantHunger plugin;
	public RespawnListener(ConstantHunger instance) {
		this.plugin = instance;
	}


	@EventHandler
	public void onRespawn(InventoryCloseEvent event) {
		HumanEntity human = event.getPlayer();
		plugin.getFoliaLib().getScheduler().runAtEntityLater(human, () -> {
			if (human.isDead() == false) {
				human.setFoodLevel(ConstantHunger.configfile.getInt("food"));
			}
		}, 500L, TimeUnit.MILLISECONDS);
	}
}