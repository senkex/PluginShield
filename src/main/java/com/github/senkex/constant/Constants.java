package com.github.senkex.constant;

/**
 * Constants used throughout the IPSecurity project.
 * <p>
 * This class contains global static constants such as the list of authorized IP addresses.
 * You can safely add more IPs to the {@code ALLOWED_IPS} array without modifying other code.
 *
 * Example:
 * <pre>
 * public static final String[] ALLOWED_IPS = {
 *     "192.168.1.108",
 *     "172.16.0.5",
 *     "203.0.113.42"
 * };
 * </pre>
 *
 * Created by Senkex
 */
public class Constants {

    /**
     * Array of IP addresses that are authorized to run the plugin.
     * <p>
     * You can add more IPs by separating them with commas inside the array.
     */
    public static final String[] ALLOWED_IPS = {
            "192.168.1.108"
            // "203.0.113.42",
            // "10.0.0.7"
    };
}