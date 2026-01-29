package com.github.senkex.license;

import com.github.senkex.checker.EnvChecker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * LicenseManager handles the validation of license keys
 * depending on the server environment (Spigot, Bungee, Velocity),
 * including optional remote license verification and external system integration.
 *
 * Created by Senkex
 */
public class LicenseManager {

    private static final String SPIGOT_KEY = "exampleSpigot";
    private static final String PROXY_KEY = "exampleProxy";

    /**
     * Validates the provided license key according to the detected server environment.
     * Performs local validation.
     *
     * @param key The license key provided in the configuration file.
     * @return true if the key matches the expected key for the environment; false otherwise.
     */
    public static boolean isKeyValid(String key) {
        if (EnvChecker.isBukkit()) {
            return SPIGOT_KEY.equals(key);
        } else if (EnvChecker.isBungee() || EnvChecker.isVelocity()) {
            return PROXY_KEY.equals(key);
        }
        return false;
    }

    /**
     * Example of a remote license validation via HTTP GET request.
     * Connects to a licensing server endpoint and validates the key remotely.
     *
     * @param key License key to validate remotely.
     * @return true if the license server confirms validity; false otherwise.
     */
    public static boolean isLicenseValidRemote(String key) {
        String licenseServerUrl = "https://example-license-server.com/api/validate?key=" + key;
        try {
            URL url = new URL(licenseServerUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000); // 3 seconds timeout
            conn.setReadTimeout(3000);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                return false;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = reader.readLine();
            reader.close();

            // Simulate: assume response is "VALID" or "INVALID"
            return "VALID".equalsIgnoreCase(line);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Example stub for license verification via Discord Bot integration.
     * Could be expanded to query a Discord bot or webhook to confirm licenses.
     *
     * @param key License key to verify through Discord.
     * @return true if the Discord bot confirms the license; false otherwise.
     */
    public static boolean isLicenseValidViaDiscordBot(String key) {
        // TODO: Implement real Discord bot API calls or webhook communication here.
        // This is just a stub to demonstrate extensibility.
        return false;
    }
}