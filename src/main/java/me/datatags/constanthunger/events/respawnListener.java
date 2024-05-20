package me.datatags.constanthunger.events;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;


public class respawnListener implements Listener {

    public ConstantHunger plugin;

    public respawnListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> {
            event.getPlayer().setFoodLevel(plugin.getConfigfile().getInt("food"));
        }, 1);
    }
}