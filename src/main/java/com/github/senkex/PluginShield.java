package com.github.senkex;

import com.github.senkex.license.LicenseManager;
import com.github.senkex.api.IPCheckAPI;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the IPSecurity plugin.
 * Handles license validation and server protection on startup.
 *
 * Created by Senkex
 */
public final class PluginShield extends JavaPlugin {

    /**
     * Called when the plugin is enabled. Validates license key and initializes protection.
     */
    @Override
    public void onEnable() {
        String userKey = getConfig().getString("license-key");

        if (!LicenseManager.isKeyValid(userKey)) {
            getLogger().warning("Invalid license. Deactivating plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // 🔐 Apply IP protection through the public API
        IPCheckAPI.initialize(this);

        // TODO: Continue plugin initialization here
    }

    /**
     * Called when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        // Optional cleanup logic
    }
}
