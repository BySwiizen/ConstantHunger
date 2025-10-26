package me.datatags.constanthunger.command;

import me.datatags.constanthunger.ConstantHunger;
import me.datatags.constanthunger.command.subcommands.HelpSubCommand;
import revxrsal.commands.annotation.Command;
import revxrsal.commands.annotation.DefaultFor;
import revxrsal.commands.bukkit.BukkitCommandActor;


@Command("constanthunger")
public class MainCommand {

	public ConstantHunger plugin;
    public HelpSubCommand helpcommand;
    public MainCommand(ConstantHunger instance) {
        this.plugin = instance;
        this.helpcommand = new HelpSubCommand(instance);
    }


    @DefaultFor("constanthunger")
    public void help(BukkitCommandActor sender) {
        helpcommand.help(sender);
    }
}