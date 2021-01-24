package net.darkunscripted.KingdomPlugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public class Death implements Listener {

    private ArrayList<String> deathmessages = new ArrayList<String>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        deathmessages.add(" got rekt by ");
        deathmessages.add(" got demolised by ");
        deathmessages.add(" got killed by ");
        deathmessages.add(" was put down by ");
        if(e.getEntity().getKiller() instanceof Player){
            int line = (int) (Math.random() * (4-1));
            e.setDeathMessage(e.getEntity().getDisplayName() + deathmessages.get(line) + e.getEntity().getKiller().getDisplayName());
        }
    }
}
