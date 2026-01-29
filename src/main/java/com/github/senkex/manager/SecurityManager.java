package com.github.senkex.manager;

import com.github.senkex.constant.Constants;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * SecurityManager is responsible for verifying if the server's IP address
 * is authorized to run the plugin.
 *
 * It compares the current server IP against a predefined list of allowed IPs
 * defined in {@link Constants}.
 *
 * Created by Senkex
 */
public class SecurityManager {

    /**
     * Checks if the server's local IP address is in the list of authorized IPs.
     *
     * @return true if the current server IP is authorized; false otherwise.
     */
    public static boolean isAuthorized() {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();

            for (String allowed : Constants.ALLOWED_IPS) {
                if (allowed.equals(ip)) {
                    return true;
                }
            }
        } catch (UnknownHostException e) {
            // Log the exception to help with debugging.
            e.printStackTrace();
        }

        return false;
    }
}