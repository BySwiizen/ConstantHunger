package me.datatags.constanthunger.command.subcommands;

import me.datatags.constanthunger.ConstantHunger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


@Command("constanthunger")
public class ReloadSubCommand {

	public ConstantHunger plugin;
    public ReloadSubCommand(ConstantHunger instance) {
        this.plugin = instance;
    }


    @Subcommand("reload")
    @CommandPermission("constanthunger.reload")
    public void reload(BukkitCommandActor sender) {
        try {
            ConstantHunger.configfile.reload();
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.setFoodLevel(ConstantHunger.configfile.getInt("food"));
			}
            ConstantHunger.messagesfile.reload();
            sender.reply(MiniMessage.miniMessage().deserialize(ConstantHunger.messagesfile.getString("prefix") + " " + ConstantHunger.messagesfile.getString("reload-success")));
        } catch (Exception error) {
            sender.reply(MiniMessage.miniMessage().deserialize("<red>Error loading files."));
            error.printStackTrace();
        }
    }
}
