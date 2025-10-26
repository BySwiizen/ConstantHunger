package me.datatags.constanthunger.listeners;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class FoodChangeListener implements Listener {

	public ConstantHunger plugin;
    public FoodChangeListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setFoodLevel(ConstantHunger.configfile.getInt("food"));
    }
}