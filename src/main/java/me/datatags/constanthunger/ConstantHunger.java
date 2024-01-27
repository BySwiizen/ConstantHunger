package me.datatags.constanthunger;

import me.datatags.constanthunger.events.changeFoodListener;
import me.datatags.constanthunger.events.joinListener;
import me.datatags.constanthunger.events.respawnListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;


public class ConstantHunger extends JavaPlugin {

    private static ConstantHunger INSTANCE;


    @Override
    public void onEnable() {
        INSTANCE = this;
        Metrics metrics = new Metrics(this, 20832);
        registerEvents();
        registerConfig();
        getLogger().info("-----------------------");
        getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
        getLogger().info("The plugin is enabled.");
        getLogger().info("-----------------------");
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info(this.getName() + " v" + this.getDescription().getVersion());
        getLogger().info("The plugin is disabled.");
        getLogger().info("------------------------");
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new changeFoodListener(), this);
        pm.registerEvents(new joinListener(), this);
        pm.registerEvents(new respawnListener(), this);
    }

    private void registerConfig() {
        File config = new File(ConstantHunger.getInstance().getDataFolder(), "config.yml");
        if (!config.exists()) {
            ConstantHunger.getInstance().getConfig().options().copyDefaults(true);
            ConstantHunger.getInstance().saveConfig();
        }
    }

    public static ConstantHunger getInstance() {
        return INSTANCE;
    }
}