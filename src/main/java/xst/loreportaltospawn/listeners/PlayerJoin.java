package xst.loreportaltospawn.listeners;

import org.bukkit.Location;
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

        if(isEnabled) {
            Player p = e.getPlayer();
            Location local = p.getLocation();
            local.setX(xCord);
            local.setY(yCord);
            local.setZ(zCord);
            local.setYaw((float) yaw);
            local.setPitch((float) pitch);
            p.teleport(local);
        }
    }
}
