package me.datatags.constanthunger.events;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class foodChangeListener implements Listener {

    public ConstantHunger plugin;

    public foodChangeListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setFoodLevel(plugin.getConfigfile().getInt("food"));
    }
}