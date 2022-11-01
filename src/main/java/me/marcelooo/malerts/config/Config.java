package me.marcelooo.malerts.config;

import me.marcelooo.malerts.MAlerts;

public class Config {
    private static String prefix;

    public static void load() {
        MAlerts.getInst().saveDefaultConfig();
        MAlerts.getInst().reloadConfig();
        prefix = MAlerts.getInst().getConfig().getString("prefix");
    }

    public static String getPrefix() {
        return prefix;
    }

}
