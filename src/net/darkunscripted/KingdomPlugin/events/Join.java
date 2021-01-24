package net.darkunscripted.KingdomPlugin.events;

import net.darkunscripted.KingdomPlugin.managers.FarmingSkill;
import net.darkunscripted.KingdomPlugin.managers.MiningSkill;
import net.darkunscripted.KingdomPlugin.managers.WoodcutterSkill;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        FarmingSkill.farmingLevel.put(e.getPlayer(), 1);
        FarmingSkill.farmingXP.put(e.getPlayer(), 0);
        MiningSkill.miningLevel.put(e.getPlayer(), 1);
        MiningSkill.miningXP.put(e.getPlayer(), 0);
        WoodcutterSkill.woodcutterLevel.put(e.getPlayer(), 1);
        WoodcutterSkill.woodcutterXP.put(e.getPlayer(), 0);
    }

}
