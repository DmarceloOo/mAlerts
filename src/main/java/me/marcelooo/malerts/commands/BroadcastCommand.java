package me.marcelooo.malerts.commands;

import me.marcelooo.malerts.MAlerts;
import me.marcelooo.malerts.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    private final MAlerts plugin;

    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public BroadcastCommand(MAlerts plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("broadcast")) {
                if (args.length < 1) {
                    sender.sendMessage(color("&8[&r&lMA&8] » &4Error! &cPlease include a message."));
                    return true;
                }
                Player p = (Player) sender;
                if (!p.hasPermission("malerts.admin")) {
                p.sendMessage(color("&8[&r&lMA&8] » &4Error! &cYou don't have permission to use this command!"));
                return false;
                }
                String temp = String.join(" ", args);
                temp = ChatColor.translateAlternateColorCodes('&', temp);
                String prefix = Config.getPrefix();
                Bukkit.getServer().broadcastMessage(color(prefix + "&r" + temp));
            }
            return true;
        }
    }