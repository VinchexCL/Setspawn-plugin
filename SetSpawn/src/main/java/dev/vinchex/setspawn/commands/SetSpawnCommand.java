package dev.vinchex.setspawn.commands;

import dev.vinchex.setspawn.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final Main plugin;

    public SetSpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location spawnLocation = player.getLocation();
                plugin.setSpawnLocation(spawnLocation);
                player.sendMessage("Spawn location set!");
                return true;
            } else if (sender instanceof ConsoleCommandSender) {
                sender.sendMessage("This command can only be executed by a player.");
                return true;
            }
        }
        return false;
    }
}