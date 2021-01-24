package net.darkunscripted.KingdomPlugin.data;

import net.darkunscripted.KingdomPlugin.managers.Kingdom;
import org.bukkit.Chunk;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ClaimedChunks {

    public static HashMap<Chunk, Kingdom> ClaimedChunks = new HashMap<>();
    public static HashMap<Player, Kingdom> PlayerInKingdomChunks = new HashMap<>();

}
