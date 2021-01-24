package net.darkunscripted.KingdomPlugin.events;

import net.darkunscripted.KingdomPlugin.Main;
import net.darkunscripted.KingdomPlugin.data.ClaimedChunks;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {

    Main plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(ClaimedChunks.ClaimedChunks.containsKey(e.getPlayer().getLocation().getChunk())){
            if(ClaimedChunks.PlayerInKingdomChunks.get(e.getPlayer()) != ClaimedChunks.ClaimedChunks.get(e.getPlayer().getLocation().getChunk())) {
                if (plugin.getConfig().getBoolean("settings.kingdom.KingdomTitle")) {
                    e.getPlayer().sendTitle("Welcome to:", ClaimedChunks.ClaimedChunks.get(e.getPlayer().getLocation().getChunk()).getName());
                    ClaimedChunks.PlayerInKingdomChunks.put(e.getPlayer(), ClaimedChunks.ClaimedChunks.get(e.getPlayer().getLocation().getChunk()));
                }
            }
        }
    }

}
