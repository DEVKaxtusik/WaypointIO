package dev.kaxtusik.waypointIO;

import dev.kaxtusik.waypointIO.api.WaypointBuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class WaypointIO {

    private static WaypointIO instance;
    private final WaypointManager waypointManager;

    private WaypointIO() {
        this.waypointManager = new WaypointManager();
    }

    public static void initialize(JavaPlugin plugin) {
        if (instance == null) {
            if (!isVersionSupported()) {
                plugin.getLogger().log(Level.SEVERE,
                        "========================================");
                plugin.getLogger().log(Level.SEVERE,
                        "WaypointIO requires Minecraft 1.21.5 or newer!");
                plugin.getLogger().log(Level.SEVERE,
                        "The Locator Bar / Waypoint feature was added in 1.21.5");
                plugin.getLogger().log(Level.SEVERE,
                        "Current version: " + Bukkit.getVersion());
                plugin.getLogger().log(Level.SEVERE,
                        "WaypointIO will NOT be initialized.");
                plugin.getLogger().log(Level.SEVERE,
                        "========================================");
                return;
            }

            instance = new WaypointIO();
            plugin.getLogger().log(Level.INFO,
                    "WaypointIO initialized successfully on " + Bukkit.getVersion());
        }
    }

    public static WaypointIO getInstance() {
        if (instance == null) {
            throw new IllegalStateException(
                    "WaypointIO not initialized! Either call WaypointIO.initialize() first " +
                            "or server version is below 1.21.5 (waypoint feature not available)"
            );
        }
        return instance;
    }

    private static boolean isVersionSupported() {
        String version = Bukkit.getBukkitVersion();

        try {
            if (version.contains("-")) {
                version = version.split("-")[0];
            }

            String[] parts = version.split("\\.");
            if (parts.length >= 3) {
                int major = Integer.parseInt(parts[0]);
                int minor = Integer.parseInt(parts[1]);
                int patch = Integer.parseInt(parts[2]);

                if (major > 1) return true;
                if (major == 1) {
                    if (minor > 21) return true;
                    if (minor == 21) {
                        return patch >= 5;
                    }
                }
            }
        } catch (Exception e) {
            Bukkit.getLogger().warning("[WaypointIO] Failed to parse version: " + version);
        }

        return false;
    }

    public WaypointManager getManager() {
        return this.waypointManager;
    }

    public WaypointBuilder builder() {
        return new WaypointBuilder();
    }
}