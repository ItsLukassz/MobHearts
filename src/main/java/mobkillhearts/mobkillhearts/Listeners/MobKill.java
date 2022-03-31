package mobkillhearts.mobkillhearts.Listeners;

import mobkillhearts.mobkillhearts.MobKillHearts;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class MobKill implements Listener {

    Plugin plugin = MobKillHearts.getPlugin(MobKillHearts.class);

    @EventHandler
    public void onMobKill(org.bukkit.event.entity.EntityDeathEvent e) {
        // we check if the entity was killed by a player
        if (e.getEntity().getKiller() != null) {
            // we get the player who killed the mob
            org.bukkit.entity.Player player = e.getEntity().getKiller();

            // we get players values from the config
            int kills = plugin.getConfig().getInt("Players." + player.getPlayer().getName() + ".Kills");
            int health = plugin.getConfig().getInt("Players." + player.getPlayer().getName() + ".Health");

            // we add 1 to the player's kills
            kills++;

            // we check if the kills is greater than the max kills
            if (kills >= plugin.getConfig().getInt("MobAmount")) {

                // we set the players kill back to 0 and add 1 to the players health
                kills = 0;
                health++;
                // and save it to the config
                plugin.getConfig().set("Players." + player.getPlayer().getName() + ".Kills", kills);
                plugin.getConfig().set("Players." + player.getPlayer().getName() + ".Health", health);
                plugin.saveConfig();
                player.sendMessage("§aYou have gained extra health!");
                player.sendMessage("§aYou now have " + health + " health!");

            } else {
                // if the kills is less than the max kills we just save it to the config
                plugin.getConfig().set("Players." + player.getPlayer().getName() + ".Kills", kills);
                plugin.saveConfig();

            }

        }
    }
}
