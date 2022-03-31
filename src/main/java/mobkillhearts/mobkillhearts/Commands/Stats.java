package mobkillhearts.mobkillhearts.Commands;

import mobkillhearts.mobkillhearts.MobKillHearts;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Stats implements CommandExecutor {

    Plugin plugin = MobKillHearts.getPlugin(MobKillHearts.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // we check if the sender is a player and not the console
        if (sender instanceof org.bukkit.entity.Player) {

            // we get the player
            org.bukkit.entity.Player player = (org.bukkit.entity.Player) sender;

            // we get values from the config
            int kills = plugin.getConfig().getInt("Players." + player.getPlayer().getName() + ".Kills");
            int health = plugin.getConfig().getInt("Players." + player.getPlayer().getName() + ".Health");
            // we get the amount of mobs in the config
            int Amount = plugin.getConfig().getInt("MobAmount");

            int KillsLeft = Amount - kills;

            // we send the message with their stats from the config Health and Kills
            player.sendMessage("§a§lMobKillHearts §f§l» §f§lStats");
            player.sendMessage("§f§l» §f§lKills: §a" + kills);
            player.sendMessage("§f§l» §f§lMobs left to kill: §a" + KillsLeft);
            player.sendMessage("§f§l» §f§lHealth: §a" + health);



        }


        return false;
    }
}
