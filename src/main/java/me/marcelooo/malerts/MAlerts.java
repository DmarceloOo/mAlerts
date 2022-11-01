package me.marcelooo.malerts;

import me.marcelooo.malerts.commands.BroadcastCommand;
import me.marcelooo.malerts.commands.ReloadCommand;
import me.marcelooo.malerts.config.Config;
import me.marcelooo.malerts.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class MAlerts extends JavaPlugin {

    private static MAlerts instance;

    @Override
    public void onEnable() {

        int pluginId = 16774;
        Metrics metrics = new Metrics(this, pluginId);

        instance = this;
        Config.load();
        getCommand("broadcast").setExecutor(new BroadcastCommand(this));
        getCommand("malerts").setExecutor(new ReloadCommand());
    }

    @Override
    public void onDisable() {

    }

    public static MAlerts getInst() {
        return instance;
    }
}