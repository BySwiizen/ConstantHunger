package me.datatags.constanthunger.listeners;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import java.util.concurrent.TimeUnit;


public class FoodChangeListener implements Listener {

	public ConstantHunger plugin;
    public FoodChangeListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent event) {
		Player player = (Player) event.getEntity();
		plugin.getFoliaLib().getScheduler().runAtEntityLater(player, () -> {
			player.setFoodLevel(ConstantHunger.configfile.getInt("food"));
		}, 500L, TimeUnit.MILLISECONDS);
	}
}