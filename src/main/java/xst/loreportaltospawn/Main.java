package xst.loreportaltospawn;

import org.bukkit.plugin.java.JavaPlugin;
import xst.loreportaltospawn.listeners.PlayerJoin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
