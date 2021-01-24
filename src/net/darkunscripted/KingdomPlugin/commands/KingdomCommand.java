package net.darkunscripted.KingdomPlugin.commands;

import net.darkunscripted.KingdomPlugin.Main;
import net.darkunscripted.KingdomPlugin.data.ClaimedChunks;
import net.darkunscripted.KingdomPlugin.managers.Kingdom;
import net.darkunscripted.KingdomPlugin.utils.Utils;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class KingdomCommand implements CommandExecutor, Listener {

    Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player){
            Player p = (Player) s;
            if(args.length == 0){
                s.sendMessage(Utils.chat("&bThis plugin is currently running " + Main.getPlugin(Main.class).getDescription().getVersion() + ".\nThis plugin was made by DarkUnScripted!\nDiscord: DarkUnScripted#1001"));
                return true;
            }else if(args.length == 1) {
                if (args[0].equalsIgnoreCase("claim")) {
                    if (p.hasPermission("kingdom.claim")) {
                        Chunk chunk = p.getLocation().getChunk();
                        Kingdom PlayersKingdom = null;
                        for (Kingdom kingdom : Kingdom.getKingdoms()) {
                            if (kingdom.getPlayers().contains(p)) {
                                PlayersKingdom = kingdom;
                            }
                        }
                        if (PlayersKingdom == null) {
                            p.sendMessage("&cYou are not in a Kingdom!");
                        } else {
                            ClaimedChunks.ClaimedChunks.put(chunk, PlayersKingdom);
                        }
                    } else {
                        p.sendMessage(Utils.chat("&cYou dont have permission to claim"));
                    }
                }
            }
        }
        if(args.length == 0){
            s.sendMessage(Utils.chat("&bThis plugin is currently running " + Main.getPlugin(Main.class).getDescription().getVersion() + ".\nThis plugin was made by DarkUnScripted!\nDiscord: DarkUnScripted#1001"));
            return true;
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("help")){
                s.sendMessage(Utils.chat("&e----&b&lKingdom&e----"));
                s.sendMessage(Utils.chat("&b/Kingdom help"));
                if(plugin.getConfig().getBoolean("options.war")) {
                    s.sendMessage(Utils.chat("&b/War help"));
                }
                if(plugin.getConfig().getBoolean("options.skills")) {
                    s.sendMessage(Utils.chat("&b/Skills help"));
                }
                return true;
            }else if(args[0].equalsIgnoreCase("reload")){
                plugin.reloadConfig();
                s.sendMessage(Utils.chat("&b&lKingdom &7>> &e&lPlugin reloaded!"));
            }
        }else if(args.length == 4){
            if(args[0].equalsIgnoreCase("create")){
                if(s.hasPermission("kingdom.create")) {
                    String name = args[1];
                    boolean check = true;
                    for (Kingdom kingdom : Kingdom.getKingdoms()) {
                        if (kingdom.getName().equalsIgnoreCase(name)) {
                            check = false;
                        }
                    }
                    if (check) {
                        
                    } else {
                        s.sendMessage(Utils.chat("&b&lKingdom &7>> &cA kingdom with that name already exists!"));
                    }
                }else{
                    s.sendMessage(Utils.chat("&b&lKingdom &7>> &cYou dont have permission!"));
                }
            }
        }
        return false;
    }

}
