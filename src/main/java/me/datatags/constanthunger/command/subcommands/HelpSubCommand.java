package me.datatags.constanthunger.command.subcommands;

import me.datatags.constanthunger.ConstantHunger;
import me.datatags.constanthunger.util.ColorUtil;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("constanthunger")
public class HelpSubCommand {

	public ConstantHunger plugin;
    public HelpSubCommand(ConstantHunger instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(BukkitCommandActor sender) {
		for (String line : ConstantHunger.messagesfile.getStringList("help")) {
			sender.reply(ColorUtil.translate(ConstantHunger.messagesfile.getString("prefix") + " " + line));
        }
	}
}