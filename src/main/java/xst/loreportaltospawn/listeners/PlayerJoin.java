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
        String conf = (String) this.plugin.getConfig().get("toggle");
        if(conf == "enabled") {
            Player p = e.getPlayer();
            Location local = p.getLocation();
            local.setX(0.766);
            local.setY(76);
            local.setZ(0.064);
            local.setYaw((float) -98.6);
            local.setPitch((float) 2.7);
            p.teleport(local);
        }else{
            Player  p = e.getPlayer();
            p.sendMessage("Somthing with the config is not working");
        }
    }
}
