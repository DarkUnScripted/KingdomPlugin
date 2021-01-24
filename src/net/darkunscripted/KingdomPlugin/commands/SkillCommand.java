package net.darkunscripted.KingdomPlugin.commands;

import net.darkunscripted.KingdomPlugin.Main;
import net.darkunscripted.KingdomPlugin.data.ProgressBar;
import net.darkunscripted.KingdomPlugin.managers.FarmingSkill;
import net.darkunscripted.KingdomPlugin.managers.MiningSkill;
import net.darkunscripted.KingdomPlugin.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class SkillCommand implements CommandExecutor, Listener {

    Main plugin = Main.getPlugin(Main.class);

    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(s instanceof Player){
            Player p = (Player) s;
            if(args.length == 0) {
                p.sendMessage(Utils.chat("&b&lSkills &7>> &e&lThere are 3 different Skills:\n&7- &b&lMining Skill\n&7- &b&lFarming Skill\n&7- &b&lWoodcutter Skill\n"));
                p.sendMessage(Utils.chat("&b&lSkills &7>> &e&lSkills are used to have a chance of getting more of a crop or getting more money out of it!"));
                p.sendMessage(Utils.chat("&b&lSkills &7>> &e&l/Skill (Skill type)"));
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("Farming")){
                    if(FarmingSkill.farmingLevel.containsKey(p) && FarmingSkill.farmingXP.containsKey(p)){
                        p.sendMessage(Utils.chat("&b&lSkills &7>> &e&lFarming level: " + FarmingSkill.farmingLevel.get(p)));
                        p.sendMessage(Utils.chat("&e&lProgress: "));
                        p.sendMessage(Utils.chat("&8[" + ProgressBar.getProgressBar(FarmingSkill.farmingXP.get(p), (int) (Math.pow(FarmingSkill.farmingLevel.get(p), 2) * 100), 40, "|", "&a", "&7") + "&8] [&a&l" + FarmingSkill.farmingXP.get(p) + "/" + (int) (Math.pow(FarmingSkill.farmingLevel.get(p), 2) * 100) + "&8]"));
                    }else{
                        p.sendMessage(Utils.chat("&b&lSkills &7>> &c&lA error has occured"));
                    }
                }else if(args[0].equalsIgnoreCase("Mining")){
                    if(MiningSkill.miningLevel.containsKey(p) && MiningSkill.miningXP.containsKey(p)){
                        p.sendMessage(Utils.chat("&b&lSkills &7>> &e&lMining level: " + MiningSkill.miningLevel.get(p)));
                        p.sendMessage(Utils.chat("&e&lProgress: "));
                        p.sendMessage(Utils.chat("&8[" + ProgressBar.getProgressBar(MiningSkill.miningXP.get(p), (int) (Math.pow(MiningSkill.miningLevel.get(p), 2) * 100), 40, "|", "&a", "&7") + "&8] [&a&l" + MiningSkill.miningXP.get(p) + "/" + (int) (Math.pow(MiningSkill.miningLevel.get(p), 2) * 100) + "&8]"));
                    }else{
                        p.sendMessage(Utils.chat("&b&lSkills &7>> &c&lA error has occured"));
                    }
                }
            }else if(args.length > 1){
                p.sendMessage(Utils.chat("&b&lSkills &7>> &e7l/Skill (Skill type)"));
            }
        }
        return false;
    }

}
