package me.datatags.constanthunger;

import dev.dejvokep.boostedyaml.YamlDocument;
import me.datatags.constanthunger.command.MainCommand;
import me.datatags.constanthunger.command.subcommands.HelpSubCommand;
import me.datatags.constanthunger.command.subcommands.ReloadSubCommand;
import me.datatags.constanthunger.listeners.FoodChangeListener;
import me.datatags.constanthunger.listeners.JoinListener;
import me.datatags.constanthunger.listeners.RespawnListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import revxrsal.commands.bukkit.BukkitCommandHandler;
import java.io.File;
import java.io.IOException;


public class ConstantHunger extends JavaPlugin {

    public static YamlDocument configfile, messagesfile;


    @Override
    public void onEnable() {
		registerMetrics();
		registerFiles();
		registerListener();
		registerCommand();
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

	private void registerMetrics() {
		new Metrics(this, 20832);
	}

	private void registerFiles() {
        configfile = loadFile("config.yml");
		messagesfile = loadFile("messages.yml");
    }

	private YamlDocument loadFile(String fileName) {
        try {
            return YamlDocument.create(new File(getDataFolder(), fileName), getResource(fileName));
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }

    private void registerListener() {
        PluginManager pluginmanager = getServer().getPluginManager();
        pluginmanager.registerEvents(new FoodChangeListener(this), this);
        pluginmanager.registerEvents(new RespawnListener(this), this);
		pluginmanager.registerEvents(new JoinListener(this), this);
    }

	private void registerCommand() {
		BukkitCommandHandler handler = BukkitCommandHandler.create(this);
		handler.register(new MainCommand(this));
		handler.register(new HelpSubCommand(this));
		handler.register(new ReloadSubCommand(this));
	}
}