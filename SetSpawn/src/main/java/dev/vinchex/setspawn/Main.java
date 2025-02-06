package dev.vinchex.setspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private Location spawnLocation;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadSpawnLocation();
    }

    @Override
    public void onDisable() {
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
        saveSpawnLocation();
    }

    private void loadSpawnLocation() {
        FileConfiguration config = getConfig();
        if (config.contains("spawn")) {
            World world = Bukkit.getWorld(config.getString("spawn.world"));
            double x = config.getDouble("spawn.x");
            double y = config.getDouble("spawn.y");
            double z = config.getDouble("spawn.z");
            float yaw = (float) config.getDouble("spawn.yaw");
            float pitch = (float) config.getDouble("spawn.pitch");
            spawnLocation = new Location(world, x, y, z, yaw, pitch);
        }
    }

    private void saveSpawnLocation() {
        if (spawnLocation != null) {
            FileConfiguration config = getConfig();
            config.set("spawn.world", spawnLocation.getWorld().getName());
            config.set("spawn.x", spawnLocation.getX());
            config.set("spawn.y", spawnLocation.getY());
            config.set("spawn.z", spawnLocation.getZ());
            config.set("spawn.yaw", spawnLocation.getYaw());
            config.set("spawn.pitch", spawnLocation.getPitch());
            saveConfig();
        }
    }
}