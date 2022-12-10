package xst.loreportaltospawn.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xst.loreportaltospawn.Main;

public class PlayerJoin implements Listener {
    Main plugin;
    public PlayerJoin(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlrJoin(PlayerJoinEvent e){
        boolean isEnabled = this.plugin.getConfig().getBoolean("toggle");

        double xCord = this.plugin.getConfig().getDouble("x");
        double yCord = this.plugin.getConfig().getDouble("y");
        double zCord = this.plugin.getConfig().getDouble("z");
        double pitch = this.plugin.getConfig().getDouble("pitch");
        double yaw = this.plugin.getConfig().getDouble("yaw");

        String worldName = this.plugin.getConfig().getString("world-name");

        if(isEnabled) {
            Player p = e.getPlayer();
            Location location = new Location(Bukkit.getWorld(worldName), xCord, yCord, zCord, (float) yaw, (float) pitch);
            if (!p.teleport(location)) {
                Bukkit.getLogger().warning("Error teleporting " + p.getName() + ". Please ensure config is correct!");
            }
        }
    }
}
