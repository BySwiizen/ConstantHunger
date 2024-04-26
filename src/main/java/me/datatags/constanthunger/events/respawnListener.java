package me.datatags.constanthunger.events;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;


public class respawnListener implements Listener {


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Bukkit.getServer().getScheduler().runTaskLater(ConstantHunger.getInstance(), () -> {
            event.getPlayer().setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
        }, 1);
    }
}