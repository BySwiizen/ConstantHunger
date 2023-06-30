package me.datatags.constanthunger;

import org.bstats.bukkit.Metrics;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class ConstantHunger extends JavaPlugin implements Listener {

    private static ConstantHunger INSTANCE;


    @Override
    public void onEnable() {
        int pluginId = 18933;
        Metrics metrics = new Metrics(this, pluginId);
        INSTANCE = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("-----------------------");
        getLogger().info(getName() + " v" + getDescription().getVersion());
        getLogger().info("The plugin is enabled.");
        getLogger().info("-----------------------");
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info(getName() + " v" + getDescription().getVersion());
        getLogger().info("The plugin is disabled.");
        getLogger().info("------------------------");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onFoodChange(FoodLevelChangeEvent event) {
        event.setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        getServer().getScheduler().runTaskLater(this, () -> {
            event.getPlayer().setFoodLevel(ConstantHunger.getInstance().getConfig().getInt("food"));
        }, 1);
    }

    public static ConstantHunger getInstance() {
        return INSTANCE;
    }
}