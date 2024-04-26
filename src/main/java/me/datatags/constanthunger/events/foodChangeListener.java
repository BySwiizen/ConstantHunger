package me.datatags.constanthunger.events;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;


public class foodChangeListener implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
    }
}