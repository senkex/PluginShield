package com.github.senkex.checker;

/**
 * EnvChecker detects the current running server environment (Bukkit, Bungee, or Velocity).
 *
 * Created by Senkex
 */
public class EnvChecker {

    /**
     * Checks if the environment is a Bukkit-based server.
     *
     * @return true if Bukkit is present.
     */
    public static boolean isBukkit() {
        try {
            Class.forName("org.bukkit.Bukkit");
            return true;
        } catch (ClassNotFoundException ignored) {}
        return false;
    }

    /**
     * Checks if the environment is a BungeeCord proxy.
     *
     * @return true if BungeeCord is present.
     */
    public static boolean isBungee() {
        try {
            Class.forName("net.md_5.bungee.api.plugin.Plugin");
            return true;
        } catch (ClassNotFoundException ignored) {}
        return false;
    }

    /**
     * Checks if the environment is a Velocity proxy.
     *
     * @return true if Velocity is present.
     */
    public static boolean isVelocity() {
        try {
            Class.forName("com.velocitypowered.api.plugin.Plugin");
            return true;
        } catch (ClassNotFoundException ignored) {}
        return false;
    }
}