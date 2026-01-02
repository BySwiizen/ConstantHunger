package me.datatags.constanthunger.command.subcommands;

import me.datatags.constanthunger.ConstantHunger;
import me.datatags.constanthunger.util.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.annotation.CommandPermission;
import revxrsal.commands.bukkit.BukkitCommandActor;


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
			sender.reply(ColorUtil.translate(ConstantHunger.messagesfile.getString("prefix") + " " + ConstantHunger.messagesfile.getString("reload-success")));
        } catch (Exception error) {
			sender.reply(ColorUtil.translate("&4Error loading files."));
            error.printStackTrace();
        }
    }
}