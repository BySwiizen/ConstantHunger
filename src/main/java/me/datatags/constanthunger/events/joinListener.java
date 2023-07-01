package me.datatags.constanthunger.events;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class joinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
    }
}