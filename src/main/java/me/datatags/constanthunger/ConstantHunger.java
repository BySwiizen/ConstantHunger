package me.datatags.constanthunger;

import dev.dejvokep.boostedyaml.YamlDocument;
import me.datatags.constanthunger.events.foodChangeListener;
import me.datatags.constanthunger.events.joinListener;
import me.datatags.constanthunger.events.respawnListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;


public class ConstantHunger extends JavaPlugin {

    private YamlDocument configfile;


    @Override
    public void onEnable() {
        registerMetrics();
        registerEvents();
        registerFiles();
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
	
	private void registerMetrics() {
		Metrics metrics = new Metrics(this, 20832);
	}

    private void registerEvents() {
        PluginManager pluginmanager = getServer().getPluginManager();
        pluginmanager.registerEvents(new foodChangeListener(this), this);
        pluginmanager.registerEvents(new joinListener(this), this);
        pluginmanager.registerEvents(new respawnListener(this), this);
    }

    private void registerFiles() {
        configfile = loadFile("config.yml");
    }

    private YamlDocument loadFile(String fileName) {
        try {
            return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }

    public YamlDocument getConfigfile() {
        return configfile;
    }
}