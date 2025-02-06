package dev.vinchex.setspawn.listeners;

import dev.vinchex.setspawn.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnListener implements Listener {

    private final Main plugin;

    public SpawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (plugin.getSpawnLocation() != null) {
            event.getPlayer().teleport(plugin.getSpawnLocation());
        }
    }
}