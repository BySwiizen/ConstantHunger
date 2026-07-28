package me.datatags.constanthunger.command.subcommands;

import me.datatags.constanthunger.ConstantHunger;
import me.datatags.constanthunger.util.ColorUtil;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.Subcommand;


@Command("constanthunger")
public class HelpSubCommand {

	public ConstantHunger plugin;
    public HelpSubCommand(ConstantHunger instance) {
        this.plugin = instance;
    }


    @Subcommand("help")
    public void help(CommandSender sender) {
		for (String line : ConstantHunger.messagesfile.getStringList("help")) {
			sender.sendMessage(ColorUtil.translate(ConstantHunger.messagesfile.getString("prefix") + " " + line));
        }
	}
}