package me.datatags.constanthunger.command.subcommands;

import me.datatags.constanthunger.ConstantHunger;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;
import revxrsal.commands.bukkit.BukkitCommandActor;
import net.kyori.adventure.text.minimessage.MiniMessage;


@Command("constanthunger")
public class HelpSubCommand {

	public ConstantHunger plugin;
    public HelpSubCommand(ConstantHunger instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(BukkitCommandActor sender) {
		for (String line : ConstantHunger.messagesfile.getStringList("help")) {
            sender.reply(MiniMessage.miniMessage().deserialize(ConstantHunger.messagesfile.getString("prefix") + " " + line));
        }
	}
}