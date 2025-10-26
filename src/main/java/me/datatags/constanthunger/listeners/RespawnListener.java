package me.datatags.constanthunger.listeners;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;


public class RespawnListener implements Listener {

    public ConstantHunger plugin;
    public RespawnListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Bukkit.getServer().getScheduler().runTaskLater(plugin, () -> {
            event.getPlayer().setFoodLevel(ConstantHunger.configfile.getInt("food"));
        }, 1);
    }
}