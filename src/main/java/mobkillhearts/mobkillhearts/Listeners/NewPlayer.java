package mobkillhearts.mobkillhearts.Listeners;

import mobkillhearts.mobkillhearts.MobKillHearts;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class NewPlayer implements Listener {


    Plugin plugin = MobKillHearts.getPlugin(MobKillHearts.class);

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {

        // Check if joined player is in the config
        if (plugin.getConfig().getString("Players." + event.getPlayer().getName()) == null) {

            // If the player file doesn't exist we create it using his uuid
            plugin.getConfig().set("Players." + event.getPlayer().getName() + ".UUID", event.getPlayer().getUniqueId().toString());
            plugin.getConfig().set("Players." + event.getPlayer().getName() + ".Kills", 0);
            plugin.getConfig().set("Players." + event.getPlayer().getName() + ".Health", 20);
            // we save the config
            plugin.saveConfig();


            event.getPlayer().sendMessage("Welcome to MobKillHearts, " + event.getPlayer().getName() + "!");
            event.getPlayer().sendMessage("You currently have " + plugin.getConfig().getInt("Players." + event.getPlayer().getName() + ".Kills") + " kills.");
            event.getPlayer().sendMessage("You currently have " + plugin.getConfig().getInt("Players." + event.getPlayer().getName() + ".Health") + " health.");

        } else{
            // We get the players kills and health from the config
            int kills = plugin.getConfig().getInt("Players." + event.getPlayer().getName() + ".Kills");
            int health = plugin.getConfig().getInt("Players." + event.getPlayer().getName() + ".Health");

            // We send the player his kills and health
            event.getPlayer().sendMessage("Welcome back to MobKillHearts, " + event.getPlayer().getName() + "!");
            event.getPlayer().sendMessage("You currently have " + kills + " kills.");
            event.getPlayer().sendMessage("You currently have " + health + " health.");

            // we set his max health to the config value
            event.getPlayer().setMaxHealth(health);


        }

    }

    }

