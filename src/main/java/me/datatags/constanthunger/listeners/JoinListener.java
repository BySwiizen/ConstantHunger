package me.datatags.constanthunger.listeners;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    public ConstantHunger plugin;
    public JoinListener(ConstantHunger instance) {
        this.plugin = instance;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setFoodLevel(ConstantHunger.configfile.getInt("food"));
    }
}