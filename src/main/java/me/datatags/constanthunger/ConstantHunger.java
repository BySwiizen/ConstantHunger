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
        files();
        Metrics metrics = new Metrics(this, 20832);
        registerEvents();getLogger().info("-----------------------");
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
        pm.registerEvents(new foodChangeListener(this), this);
        pm.registerEvents(new joinListener(this), this);
        pm.registerEvents(new respawnListener(this), this);
    }

    private void files() {
        configfile = loadFile("config.yml");
    }

    private YamlDocument loadFile(String fileName) {
        try {
            return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public YamlDocument getConfigfile() {
        return configfile;
    }
}