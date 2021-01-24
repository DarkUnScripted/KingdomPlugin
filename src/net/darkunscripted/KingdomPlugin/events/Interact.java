package net.darkunscripted.KingdomPlugin.events;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Crops;

public class Interact implements Listener {

    @EventHandler
    private void cropTrample(PlayerInteractEvent e){
        if(e.getAction() != Action.PHYSICAL) {return;}
        if(!e.hasBlock()) {return;}

        final Block farmland = e.getClickedBlock();
        if(farmland == null) return;
        final Block crop = farmland.getRelative(BlockFace.UP);
        if(farmland.getState().getData() instanceof Crops) {return;}
        e.setCancelled(true);
    }

}
