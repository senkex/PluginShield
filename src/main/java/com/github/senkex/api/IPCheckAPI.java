package com.github.senkex.api;

import com.github.senkex.handler.ProtectionHandler;

import org.bukkit.plugin.Plugin;

/**
 * Public API to initialize the IP protection logic for a plugin.
 *
 * Created by Senkex
 */
public class IPCheckAPI {

    /**
     * Initializes the IP protection layer.
     *
     * @param plugin The plugin instance requesting initialization.
     */
    public static void initialize(Plugin plugin) {
        ProtectionHandler.applyProtection(plugin);
    }
}