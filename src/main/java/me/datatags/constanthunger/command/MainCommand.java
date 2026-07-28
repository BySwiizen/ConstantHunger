package me.datatags.constanthunger.command;

import me.datatags.constanthunger.ConstantHunger;
import me.datatags.constanthunger.command.subcommands.HelpSubCommand;
import org.bukkit.command.CommandSender;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.CommandPlaceholder;


@Command("constanthunger")
public class MainCommand {

	public ConstantHunger plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(ConstantHunger instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


	@CommandPlaceholder
    public void help(CommandSender sender) {
        helpcommand.help(sender);
    }
}