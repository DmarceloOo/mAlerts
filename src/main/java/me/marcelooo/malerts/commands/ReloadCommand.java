package me.marcelooo.malerts.commands;

import me.marcelooo.malerts.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    public String color(String string) {
            return ChatColor.translateAlternateColorCodes('&', string);
        }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Config.load();
            sender.sendMessage("# [MA] Config has been reloaded");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("malerts.admin")) {
            p.sendMessage(color("&8[&r&lMA&8] » &4Error! &cYou don't have permission to use this command!"));
            return false;
        }
        Config.load();
        p.sendMessage(color("&8[&r&lMA&8] » &aConfig has been reloaded!"));
        return true;
    }
}
