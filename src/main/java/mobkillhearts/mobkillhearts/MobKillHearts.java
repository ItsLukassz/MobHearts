package mobkillhearts.mobkillhearts;

import mobkillhearts.mobkillhearts.Commands.Stats;
import mobkillhearts.mobkillhearts.Listeners.NewPlayer;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MobKillHearts extends JavaPlugin implements Listener {

    private static MobKillHearts plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        System.out.println("Custom Crypto Miners Started!");

        // events
        getServer().getPluginManager().registerEvents(new NewPlayer(), this);


        // commands
        getCommand("stats").setExecutor(new Stats());


        //config.yml and players.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();




    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
