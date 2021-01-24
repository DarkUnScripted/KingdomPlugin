package net.darkunscripted.KingdomPlugin.events;

import net.darkunscripted.KingdomPlugin.managers.Kingdom;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        boolean checker = true;
        for(Kingdom kingdom : Kingdom.getKingdoms()){
            for(Player p : kingdom.getPlayers()){
                if(p == e.getPlayer()){
                    e.setFormat("[" + kingdom.getTag() + "] " + e.getPlayer().getDisplayName() + ": " + e.getMessage());
                    checker = false;
                }
            }
        }
        if(checker){
            e.setFormat("[---] " + e.getPlayer().getDisplayName() + ": " + e.getMessage());
        }
    }

}
